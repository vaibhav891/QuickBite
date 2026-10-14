package com.quickbite.app.domain.model

data class Restaurant(
    val id: String,
    val name: String,
    val description: String,
    val cuisineTypes: List<String>,
    val imageUrl: String,
    val isOpen: Boolean = true,
    val deliveryFeeMinor: Long = 4900, // ₹49 default
    val estimatedDeliveryMinutes: Int = 30,
    val rating: Double = 4.8,
    val ratingCount: Int = 340,
    val address: String = "Downtown Culinary District",
    val latitude: Double = 19.0760,
    val longitude: Double = 72.8777
) {
    val formattedDeliveryFee: String
        get() = if (deliveryFeeMinor == 0L) "Free Delivery" else "₹${deliveryFeeMinor / 100}"

    val formattedCuisines: String
        get() = cuisineTypes.joinToString(" • ")
}
