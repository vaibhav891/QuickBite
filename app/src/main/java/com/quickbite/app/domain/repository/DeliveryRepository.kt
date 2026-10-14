package com.quickbite.app.domain.repository

import com.quickbite.app.core.location.Coordinates
import com.quickbite.app.domain.model.Delivery
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface DeliveryRepository {
    val isSimulating: StateFlow<Boolean>
    fun getDelivery(orderId: String): Flow<Delivery?>
    fun getRouteWaypoints(): List<Coordinates>
    suspend fun advanceSimulationStep(orderId: String): Result<Delivery>
    fun startAutoSimulation(orderId: String)
    fun stopAutoSimulation()
    suspend fun markDelivered(orderId: String): Result<Unit>
}
