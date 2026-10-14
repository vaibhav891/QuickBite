package com.quickbite.app.domain.model

enum class OrderStatus(val displayName: String, val stepOrder: Int) {
    PLACED("Order Placed", 0),
    ACCEPTED("Accepted", 1),
    PREPARING("Preparing Food", 2),
    READY_FOR_PICKUP("Ready for Pickup", 3),
    PICKED_UP("Out for Delivery", 4),
    DELIVERED("Delivered", 5),
    REJECTED("Rejected", -1),
    CANCELLED("Cancelled", -1);

    fun isTerminal(): Boolean = this == DELIVERED || this == REJECTED || this == CANCELLED

    fun allowedNextStatuses(): List<OrderStatus> {
        return when (this) {
            PLACED -> listOf(ACCEPTED, REJECTED, CANCELLED)
            ACCEPTED -> listOf(PREPARING, CANCELLED)
            PREPARING -> listOf(READY_FOR_PICKUP)
            READY_FOR_PICKUP -> listOf(PICKED_UP)
            PICKED_UP -> listOf(DELIVERED)
            DELIVERED, REJECTED, CANCELLED -> emptyList()
        }
    }

    fun canTransitionTo(next: OrderStatus): Boolean {
        return allowedNextStatuses().contains(next)
    }
}
