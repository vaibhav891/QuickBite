package com.quickbite.app.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.quickbite.app.core.location.Coordinates
import com.quickbite.app.core.location.SimulatedLocationEngine
import com.quickbite.app.domain.model.Delivery
import com.quickbite.app.domain.model.DeliveryStatus
import com.quickbite.app.domain.repository.DeliveryRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DeliveryRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val simulationEngine: SimulatedLocationEngine
) : DeliveryRepository {

    override val isSimulating: StateFlow<Boolean> = simulationEngine.isSimulating

    private val localDeliveries = MutableStateFlow<Map<String, Delivery>>(
        mapOf(
            "order_active_01" to Delivery(
                orderId = "order_active_01",
                deliveryPartnerId = "demo_rider_01",
                deliveryPartnerName = "Alex Rivera (Courier)",
                status = DeliveryStatus.IN_TRANSIT,
                currentLatitude = 19.0805,
                currentLongitude = 72.8842,
                currentStepIndex = 3,
                totalSteps = 10,
                routeProgressPercent = 33
            )
        )
    )

    private val scope = CoroutineScope(Dispatchers.Default)

    override fun getDelivery(orderId: String): Flow<Delivery?> = localDeliveries.map {
        it[orderId] ?: Delivery(orderId = orderId)
    }

    override fun getRouteWaypoints(): List<Coordinates> {
        return simulationEngine.routeWaypoints
    }

    override suspend fun advanceSimulationStep(orderId: String): Result<Delivery> {
        val current = localDeliveries.value[orderId] ?: Delivery(orderId = orderId)
        val nextStep = (current.currentStepIndex + 1).coerceAtMost(simulationEngine.routeWaypoints.size - 1)
        val coord = simulationEngine.getCurrentCoordinate(nextStep)
        val progress = simulationEngine.getProgressPercent(nextStep)
        val status = if (progress >= 100) DeliveryStatus.DELIVERED else DeliveryStatus.IN_TRANSIT

        val updated = current.copy(
            status = status,
            currentLatitude = coord.latitude,
            currentLongitude = coord.longitude,
            currentStepIndex = nextStep,
            totalSteps = simulationEngine.routeWaypoints.size,
            routeProgressPercent = progress,
            updatedAtMs = System.currentTimeMillis()
        )

        localDeliveries.value = localDeliveries.value + (orderId to updated)

        try {
            firestore.collection("deliveries").document(orderId).set(
                mapOf(
                    "currentLatitude" to coord.latitude,
                    "currentLongitude" to coord.longitude,
                    "currentStepIndex" to nextStep,
                    "routeProgressPercent" to progress,
                    "status" to status.name
                )
            ).await()
        } catch (_: Exception) {}

        return Result.success(updated)
    }

    override fun startAutoSimulation(orderId: String) {
        simulationEngine.startSimulation(intervalMs = 3000L) { step, coord ->
            scope.launch {
                advanceSimulationStep(orderId)
            }
        }
    }

    override fun stopAutoSimulation() {
        simulationEngine.stopSimulation()
    }

    override suspend fun markDelivered(orderId: String): Result<Unit> {
        val current = localDeliveries.value[orderId] ?: Delivery(orderId = orderId)
        val lastCoord = simulationEngine.routeWaypoints.last()
        val updated = current.copy(
            status = DeliveryStatus.DELIVERED,
            currentLatitude = lastCoord.latitude,
            currentLongitude = lastCoord.longitude,
            currentStepIndex = simulationEngine.routeWaypoints.size - 1,
            routeProgressPercent = 100,
            updatedAtMs = System.currentTimeMillis()
        )
        localDeliveries.value = localDeliveries.value + (orderId to updated)
        stopAutoSimulation()
        return Result.success(Unit)
    }
}
