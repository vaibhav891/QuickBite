package com.quickbite.app.core.location

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin

@Singleton
class SimulatedLocationEngine @Inject constructor() {

    // Predefined deterministic route coordinates between Downtown Bistro and Residential Address
    val routeWaypoints: List<Coordinates> = listOf(
        Coordinates(19.0760, 72.8777, "Golden Dragon Bistro (Pickup Point)"),
        Coordinates(19.0772, 72.8795, "Turning onto Main Culinary Boulevard"),
        Coordinates(19.0788, 72.8818, "Approaching Metro Junction"),
        Coordinates(19.0805, 72.8842, "Passing Central Park South"),
        Coordinates(19.0820, 72.8865, "Crossing Riverside Flyover"),
        Coordinates(19.0838, 72.8889, "Entering Palm Avenue"),
        Coordinates(19.0852, 72.8910, "Passing Green Market Arcade"),
        Coordinates(19.0865, 72.8928, "Approaching Hill Road Corner"),
        Coordinates(19.0874, 72.8942, "Entering Residential Sector 4"),
        Coordinates(19.0880, 72.8950, "Green Glen Heights (Customer Destination)")
    )

    private val _currentStep = MutableStateFlow(0)
    val currentStep: StateFlow<Int> = _currentStep.asStateFlow()

    private val _isSimulating = MutableStateFlow(false)
    val isSimulating: StateFlow<Boolean> = _isSimulating.asStateFlow()

    private var simulationJob: Job? = null
    private val scope = CoroutineScope(Dispatchers.Default)

    fun getCurrentCoordinate(step: Int = _currentStep.value): Coordinates {
        val index = step.coerceIn(0, routeWaypoints.size - 1)
        return routeWaypoints[index]
    }

    fun getProgressPercent(step: Int = _currentStep.value): Int {
        if (routeWaypoints.size <= 1) return 100
        val index = step.coerceIn(0, routeWaypoints.size - 1)
        return ((index.toFloat() / (routeWaypoints.size - 1)) * 100).toInt()
    }

    fun calculateBearing(from: Coordinates, to: Coordinates): Float {
        val lat1 = Math.toRadians(from.latitude)
        val lon1 = Math.toRadians(from.longitude)
        val lat2 = Math.toRadians(to.latitude)
        val lon2 = Math.toRadians(to.longitude)

        val dLon = lon2 - lon1
        val y = sin(dLon) * cos(lat2)
        val x = cos(lat1) * sin(lat2) - sin(lat1) * cos(lat2) * cos(dLon)
        val radians = atan2(y, x)
        return ((Math.toDegrees(radians) + 360) % 360).toFloat()
    }

    /**
     * Advances simulation by one deterministic step.
     * Perfect for instant demonstration in client meetings.
     */
    fun advanceStep(): Int {
        val next = (_currentStep.value + 1).coerceAtMost(routeWaypoints.size - 1)
        _currentStep.value = next
        return next
    }

    fun setStep(step: Int) {
        _currentStep.value = step.coerceIn(0, routeWaypoints.size - 1)
    }

    fun reset() {
        stopSimulation()
        _currentStep.value = 0
    }

    /**
     * Starts continuous auto-advance simulation every [intervalMs].
     */
    fun startSimulation(intervalMs: Long = 3000L, onStep: ((Int, Coordinates) -> Unit)? = null) {
        if (_isSimulating.value) return
        _isSimulating.value = true

        simulationJob = scope.launch {
            while (_isSimulating.value && _currentStep.value < routeWaypoints.size - 1) {
                delay(intervalMs)
                val newStep = advanceStep()
                val coord = getCurrentCoordinate(newStep)
                onStep?.invoke(newStep, coord)
                if (newStep >= routeWaypoints.size - 1) {
                    _isSimulating.value = false
                    break
                }
            }
        }
    }

    fun stopSimulation() {
        _isSimulating.value = false
        simulationJob?.cancel()
        simulationJob = null
    }
}
