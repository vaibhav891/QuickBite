package com.quickbite.app.domain.repository

import com.quickbite.app.domain.model.CartItem
import com.quickbite.app.domain.model.Order
import com.quickbite.app.domain.model.OrderEvent
import com.quickbite.app.domain.model.OrderStatus
import kotlinx.coroutines.flow.Flow

data class PaymentDraftResult(
    val orderDraftId: String,
    val paymentIntentId: String,
    val clientSecret: String,
    val totalMinor: Long,
    val subtotalMinor: Long,
    val deliveryFeeMinor: Long,
    val taxMinor: Long
)

interface OrderRepository {
    fun getOrdersForCustomer(customerId: String): Flow<List<Order>>
    fun getOrdersForRestaurant(restaurantId: String): Flow<List<Order>>
    fun getAvailableDeliveries(): Flow<List<Order>>
    fun getAssignedDeliveries(deliveryPartnerId: String): Flow<List<Order>>
    fun getOrderById(orderId: String): Flow<Order?>
    fun getOrderEvents(orderId: String): Flow<List<OrderEvent>>

    suspend fun createCheckoutDraft(
        restaurantId: String,
        restaurantName: String,
        items: List<CartItem>,
        deliveryAddress: String
    ): Result<PaymentDraftResult>

    suspend fun confirmAndPlaceOrder(
        draft: PaymentDraftResult,
        customerId: String,
        customerName: String,
        restaurantId: String,
        restaurantName: String,
        items: List<CartItem>,
        deliveryAddress: String,
        isMockPayment: Boolean
    ): Result<Order>

    suspend fun updateOrderStatus(
        orderId: String,
        newStatus: OrderStatus,
        actorId: String,
        actorRole: String,
        note: String? = null,
        rejectReason: String? = null
    ): Result<Unit>

    suspend fun claimDelivery(orderId: String, deliveryPartnerId: String, deliveryPartnerName: String): Result<Unit>
}
