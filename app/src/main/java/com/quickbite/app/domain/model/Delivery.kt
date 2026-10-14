package com.quickbite.app.domain.model

enum class DeliveryStatus(val displayName: String) {
    UNASSIGNED("Awaiting Rider"),
    READY_FOR_PICKUP("Ready at Restaurant"),
    IN_TRANSIT("Out for Delivery"),
    DELIVERED("Delivered")
}

data class Delivery(
    val orderId: String,
    val deliveryPartnerId: String? = null,
    val deliveryPartnerName: String? = "Alex Rivera (Courier)",
    val status: DeliveryStatus = DeliveryStatus.UNASSIGNED,
    val currentLatitude: Double = 19.0760,
    val currentLongitude: Double = 72.8777,
    val destinationLatitude: Double = 19.0880,
    val destinationLongitude: Double = 72.8950,
    val currentStepIndex: Int = 0,
    val totalSteps: Int = 10,
    val routeProgressPercent: Int = 0,
    val updatedAtMs: Long = System.currentTimeMillis()
)
