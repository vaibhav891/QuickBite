package com.quickbite.app.domain.model

data class OrderItem(
    val itemId: String,
    val name: String,
    val quantity: Int,
    val unitPriceMinor: Long,
    val totalPriceMinor: Long
) {
    val formattedUnitPrice: String
        get() = "₹${unitPriceMinor / 100}"

    val formattedTotalPrice: String
        get() = "₹${totalPriceMinor / 100}"
}
