package com.quickbite.app.domain.model

data class CartItem(
    val menuItem: MenuItem,
    val quantity: Int
) {
    val totalPriceMinor: Long
        get() = menuItem.priceMinor * quantity

    val formattedTotalPrice: String
        get() = "₹${totalPriceMinor / 100}"
}
