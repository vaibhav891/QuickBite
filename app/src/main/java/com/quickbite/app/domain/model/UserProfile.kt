package com.quickbite.app.domain.model

data class UserProfile(
    val id: String,
    val name: String,
    val email: String,
    val role: UserRole,
    val restaurantId: String? = null,
    val deliveryPartnerId: String? = null,
    val isDemoAccount: Boolean = true
)
