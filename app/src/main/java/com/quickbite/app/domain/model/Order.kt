package com.quickbite.app.domain.model

data class Order(
    val orderId: String,
    val orderNumber: String,
    val customerId: String,
    val customerName: String,
    val restaurantId: String,
    val restaurantName: String,
    val deliveryPartnerId: String? = null,
    val deliveryPartnerName: String? = null,
    val items: List<OrderItem>,
    val deliveryAddress: String,
    val subtotalMinor: Long,
    val deliveryFeeMinor: Long,
    val taxMinor: Long,
    val totalMinor: Long,
    val currency: String = "INR",
    val paymentStatus: String = "PAID",
    val paymentMethod: String = "STRIPE_TEST_CARD",
    val paymentIntentId: String = "",
    val status: OrderStatus = OrderStatus.PLACED,
    val createdAtMs: Long = System.currentTimeMillis(),
    val updatedAtMs: Long = System.currentTimeMillis(),
    val estimatedDeliveryMinutes: Int = 30,
    val rejectReason: String? = null
) {
    val formattedSubtotal: String get() = "₹${subtotalMinor / 100}"
    val formattedDeliveryFee: String get() = "₹${deliveryFeeMinor / 100}"
    val formattedTax: String get() = "₹${taxMinor / 100}"
    val formattedTotal: String get() = "₹${totalMinor / 100}"
    val totalItemCount: Int get() = items.sumOf { it.quantity }
}
