package com.quickbite.app.domain.model

data class OrderEvent(
    val eventId: String,
    val orderId: String,
    val previousStatus: OrderStatus?,
    val newStatus: OrderStatus,
    val actorId: String,
    val actorRole: String,
    val timestampMs: Long,
    val note: String
)
