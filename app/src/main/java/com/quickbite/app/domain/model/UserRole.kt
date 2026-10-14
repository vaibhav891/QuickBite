package com.quickbite.app.domain.model

enum class UserRole(val displayName: String, val description: String) {
    CUSTOMER("Customer", "Browse restaurants, place orders & track live delivery"),
    RESTAURANT("Restaurant", "Accept orders, prepare food & alert riders"),
    DELIVERY_PARTNER("Delivery Partner", "Claim orders, pick up food & deliver")
}
