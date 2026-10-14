package com.quickbite.app.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.functions.FirebaseFunctions
import com.quickbite.app.core.common.CurrencyUtils
import com.quickbite.app.data.seed.SeedData
import com.quickbite.app.domain.model.CartItem
import com.quickbite.app.domain.model.Order
import com.quickbite.app.domain.model.OrderEvent
import com.quickbite.app.domain.model.OrderItem
import com.quickbite.app.domain.model.OrderStatus
import com.quickbite.app.domain.repository.OrderRepository
import com.quickbite.app.domain.repository.PaymentDraftResult
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.tasks.await
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OrderRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val functions: FirebaseFunctions
) : OrderRepository {

    // Shared reactive in-memory order cache to support instant demo transitions
    private val localOrders = MutableStateFlow<List<Order>>(SeedData.initialOrders)

    override fun getOrdersForCustomer(customerId: String): Flow<List<Order>> = callbackFlow {
        // Emit initial local orders immediately
        trySend(localOrders.value.filter { it.customerId == customerId })

        val listener = firestore.collection("orders")
            .whereEqualTo("customerId", customerId)
            .orderBy("createdAtMs", Query.Direction.DESCENDING)
            .addSnapshotListener { snapshot, error ->
                if (error != null || snapshot == null || snapshot.isEmpty) {
                    trySend(localOrders.value.filter { it.customerId == customerId })
                    return@addSnapshotListener
                }

                val remote = snapshot.documents.mapNotNull { parseOrder(it) }
                // Merge with local orders
                val merged = (remote + localOrders.value.filter { it.customerId == customerId })
                    .distinctBy { it.orderId }
                    .sortedByDescending { it.createdAtMs }

                trySend(merged)
            }

        awaitClose { listener.remove() }
    }

    override fun getOrdersForRestaurant(restaurantId: String): Flow<List<Order>> = callbackFlow {
        trySend(localOrders.value.filter { it.restaurantId == restaurantId })

        val listener = firestore.collection("orders")
            .whereEqualTo("restaurantId", restaurantId)
            .addSnapshotListener { snapshot, error ->
                if (error != null || snapshot == null || snapshot.isEmpty) {
                    trySend(localOrders.value.filter { it.restaurantId == restaurantId })
                    return@addSnapshotListener
                }

                val remote = snapshot.documents.mapNotNull { parseOrder(it) }
                val merged = (remote + localOrders.value.filter { it.restaurantId == restaurantId })
                    .distinctBy { it.orderId }
                    .sortedByDescending { it.createdAtMs }

                trySend(merged)
            }

        awaitClose { listener.remove() }
    }

    override fun getAvailableDeliveries(): Flow<List<Order>> = localOrders.map { orders ->
        orders.filter { it.status == OrderStatus.READY_FOR_PICKUP && it.deliveryPartnerId == null }
    }

    override fun getAssignedDeliveries(deliveryPartnerId: String): Flow<List<Order>> = localOrders.map { orders ->
        orders.filter { it.deliveryPartnerId == deliveryPartnerId }
    }

    override fun getOrderById(orderId: String): Flow<Order?> = localOrders.map { orders ->
        orders.find { it.orderId == orderId }
    }

    override fun getOrderEvents(orderId: String): Flow<List<OrderEvent>> = callbackFlow {
        val initialEvents = listOf(
            OrderEvent(
                eventId = "ev_01",
                orderId = orderId,
                previousStatus = null,
                newStatus = OrderStatus.PLACED,
                actorId = "customer",
                actorRole = "CUSTOMER",
                timestampMs = System.currentTimeMillis() - (15 * 60 * 1000),
                note = "Order placed and payment authorized"
            )
        )
        trySend(initialEvents)

        val listener = firestore.collection("orders")
            .document(orderId)
            .collection("events")
            .orderBy("timestamp", Query.Direction.ASCENDING)
            .addSnapshotListener { snapshot, error ->
                if (error != null || snapshot == null || snapshot.isEmpty) {
                    trySend(initialEvents)
                    return@addSnapshotListener
                }

                val events = snapshot.documents.mapNotNull { doc ->
                    try {
                        OrderEvent(
                            eventId = doc.id,
                            orderId = orderId,
                            previousStatus = doc.getString("previousStatus")?.let { OrderStatus.valueOf(it) },
                            newStatus = OrderStatus.valueOf(doc.getString("newStatus") ?: "PLACED"),
                            actorId = doc.getString("actorId") ?: "",
                            actorRole = doc.getString("actorRole") ?: "CUSTOMER",
                            timestampMs = doc.getTimestamp("timestamp")?.toDate()?.time ?: System.currentTimeMillis(),
                            note = doc.getString("note") ?: ""
                        )
                    } catch (e: Exception) {
                        null
                    }
                }
                trySend(events)
            }

        awaitClose { listener.remove() }
    }

    override suspend fun createCheckoutDraft(
        restaurantId: String,
        restaurantName: String,
        items: List<CartItem>,
        deliveryAddress: String
    ): Result<PaymentDraftResult> {
        val subtotal = items.sumOf { it.totalPriceMinor }
        val deliveryFee = 4900L // ₹49
        val tax = CurrencyUtils.calculateTaxMinor(subtotal)
        val total = subtotal + deliveryFee + tax

        return try {
            // Try calling Cloud Function createPaymentIntent
            val callData = mapOf(
                "restaurantId" to restaurantId,
                "deliveryAddress" to deliveryAddress,
                "items" to items.map {
                    mapOf("itemId" to it.menuItem.id, "quantity" to it.quantity)
                }
            )

            val result = functions.getHttpsCallable("createPaymentIntent").call(callData).await()
            val data = result.data as? Map<*, *>

            val draftId = data?.get("orderDraftId")?.toString() ?: "draft_${UUID.randomUUID()}"
            val clientSecret = data?.get("clientSecret")?.toString() ?: "pi_mock_secret_${System.currentTimeMillis()}"
            val paymentIntentId = data?.get("paymentIntentId")?.toString() ?: "pi_mock_${System.currentTimeMillis()}"

            Result.success(
                PaymentDraftResult(
                    orderDraftId = draftId,
                    paymentIntentId = paymentIntentId,
                    clientSecret = clientSecret,
                    totalMinor = (data?.get("totalMinor") as? Number)?.toLong() ?: total,
                    subtotalMinor = (data?.get("subtotalMinor") as? Number)?.toLong() ?: subtotal,
                    deliveryFeeMinor = (data?.get("deliveryFeeMinor") as? Number)?.toLong() ?: deliveryFee,
                    taxMinor = (data?.get("taxMinor") as? Number)?.toLong() ?: tax
                )
            )
        } catch (e: Exception) {
            // Local fallback draft for offline / emulator demo mode
            Result.success(
                PaymentDraftResult(
                    orderDraftId = "draft_${UUID.randomUUID().toString().take(8)}",
                    paymentIntentId = "pi_mock_${System.currentTimeMillis()}",
                    clientSecret = "pi_mock_secret_${UUID.randomUUID().toString().take(12)}",
                    totalMinor = total,
                    subtotalMinor = subtotal,
                    deliveryFeeMinor = deliveryFee,
                    taxMinor = tax
                )
            )
        }
    }

    override suspend fun confirmAndPlaceOrder(
        draft: PaymentDraftResult,
        customerId: String,
        customerName: String,
        restaurantId: String,
        restaurantName: String,
        items: List<CartItem>,
        deliveryAddress: String,
        isMockPayment: Boolean
    ): Result<Order> {
        val orderId = "order_${System.currentTimeMillis()}"
        val orderNumber = "QB-${(100000..999999).random()}"

        val orderItems = items.map {
            OrderItem(
                itemId = it.menuItem.id,
                name = it.menuItem.name,
                quantity = it.quantity,
                unitPriceMinor = it.menuItem.priceMinor,
                totalPriceMinor = it.totalPriceMinor
            )
        }

        val newOrder = Order(
            orderId = orderId,
            orderNumber = orderNumber,
            customerId = customerId,
            customerName = customerName,
            restaurantId = restaurantId,
            restaurantName = restaurantName,
            deliveryPartnerId = null,
            items = orderItems,
            deliveryAddress = deliveryAddress,
            subtotalMinor = draft.subtotalMinor,
            deliveryFeeMinor = draft.deliveryFeeMinor,
            taxMinor = draft.taxMinor,
            totalMinor = draft.totalMinor,
            paymentStatus = "PAID",
            paymentMethod = if (isMockPayment) "TEST_MODE_QUICKPAY" else "STRIPE_TEST_CARD",
            paymentIntentId = draft.paymentIntentId,
            status = OrderStatus.PLACED,
            createdAtMs = System.currentTimeMillis(),
            updatedAtMs = System.currentTimeMillis()
        )

        // Add to local state flow for instantaneous UI update across roles
        localOrders.value = listOf(newOrder) + localOrders.value

        // Also persist to Firestore if available
        try {
            firestore.collection("orders").document(orderId).set(
                mapOf(
                    "orderId" to orderId,
                    "orderNumber" to orderNumber,
                    "customerId" to customerId,
                    "customerName" to customerName,
                    "restaurantId" to restaurantId,
                    "restaurantName" to restaurantName,
                    "deliveryAddress" to deliveryAddress,
                    "subtotalMinor" to draft.subtotalMinor,
                    "deliveryFeeMinor" to draft.deliveryFeeMinor,
                    "taxMinor" to draft.taxMinor,
                    "totalMinor" to draft.totalMinor,
                    "paymentStatus" to "PAID",
                    "status" to "PLACED",
                    "createdAtMs" to System.currentTimeMillis()
                )
            ).await()
        } catch (_: Exception) {}

        return Result.success(newOrder)
    }

    override suspend fun updateOrderStatus(
        orderId: String,
        newStatus: OrderStatus,
        actorId: String,
        actorRole: String,
        note: String?,
        rejectReason: String?
    ): Result<Unit> {
        val currentOrder = localOrders.value.find { it.orderId == orderId }
            ?: return Result.failure(IllegalStateException("Order not found"))

        // State Machine validation
        if (!currentOrder.status.canTransitionTo(newStatus)) {
            return Result.failure(
                IllegalStateException("Cannot transition order from ${currentOrder.status} to $newStatus")
            )
        }

        val updatedOrder = currentOrder.copy(
            status = newStatus,
            rejectReason = rejectReason ?: currentOrder.rejectReason,
            updatedAtMs = System.currentTimeMillis()
        )

        localOrders.value = localOrders.value.map {
            if (it.orderId == orderId) updatedOrder else it
        }

        try {
            firestore.collection("orders").document(orderId).update(
                mapOf(
                    "status" to newStatus.name,
                    "rejectReason" to rejectReason,
                    "updatedAtMs" to System.currentTimeMillis()
                )
            ).await()
        } catch (_: Exception) {}

        return Result.success(Unit)
    }

    override suspend fun claimDelivery(
        orderId: String,
        deliveryPartnerId: String,
        deliveryPartnerName: String
    ): Result<Unit> {
        val currentOrder = localOrders.value.find { it.orderId == orderId }
            ?: return Result.failure(IllegalStateException("Order not found"))

        val updated = currentOrder.copy(
            deliveryPartnerId = deliveryPartnerId,
            deliveryPartnerName = deliveryPartnerName,
            updatedAtMs = System.currentTimeMillis()
        )

        localOrders.value = localOrders.value.map {
            if (it.orderId == orderId) updated else it
        }

        try {
            firestore.collection("orders").document(orderId).update(
                mapOf(
                    "deliveryPartnerId" to deliveryPartnerId,
                    "deliveryPartnerName" to deliveryPartnerName
                )
            ).await()
        } catch (_: Exception) {}

        return Result.success(Unit)
    }

    private fun parseOrder(doc: com.google.firebase.firestore.DocumentSnapshot): Order? {
        return try {
            Order(
                orderId = doc.id,
                orderNumber = doc.getString("orderNumber") ?: "QB-000000",
                customerId = doc.getString("customerId") ?: "",
                customerName = doc.getString("customerName") ?: "Customer",
                restaurantId = doc.getString("restaurantId") ?: "",
                restaurantName = doc.getString("restaurantName") ?: "",
                deliveryPartnerId = doc.getString("deliveryPartnerId"),
                deliveryPartnerName = doc.getString("deliveryPartnerName"),
                items = emptyList(),
                deliveryAddress = doc.getString("deliveryAddress") ?: "",
                subtotalMinor = doc.getLong("subtotalMinor") ?: 0L,
                deliveryFeeMinor = doc.getLong("deliveryFeeMinor") ?: 4900L,
                taxMinor = doc.getLong("taxMinor") ?: 0L,
                totalMinor = doc.getLong("totalMinor") ?: 0L,
                status = OrderStatus.valueOf(doc.getString("status") ?: "PLACED"),
                createdAtMs = doc.getLong("createdAtMs") ?: System.currentTimeMillis(),
                updatedAtMs = doc.getLong("updatedAtMs") ?: System.currentTimeMillis()
            )
        } catch (e: Exception) {
            null
        }
    }
}
