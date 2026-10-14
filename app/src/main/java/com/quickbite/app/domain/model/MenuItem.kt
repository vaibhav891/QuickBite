package com.quickbite.app.domain.model

data class MenuItem(
    val id: String,
    val restaurantId: String,
    val name: String,
    val description: String,
    val priceMinor: Long, // Integer minor units (e.g. 29900 = ₹299.00)
    val imageUrl: String,
    val category: String,
    val isAvailable: Boolean = true,
    val isVegetarian: Boolean = false,
    val calories: Int? = null
) {
    val formattedPrice: String
        get() = "₹${priceMinor / 100}"
}
