package com.quickbite.app

import com.quickbite.app.core.location.Coordinates
import com.quickbite.app.core.location.SimulatedLocationEngine
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class SimulatedLocationEngineTest {

    private lateinit var engine: SimulatedLocationEngine

    @Before
    fun setUp() {
        engine = SimulatedLocationEngine()
    }

    @Test
    fun testWaypointsNotEmptyAndStartAtRestaurant() {
        assertTrue(engine.routeWaypoints.size >= 10)
        val first = engine.getCurrentCoordinate(0)
        assertEquals(19.0760, first.latitude, 0.0001)
        assertEquals(72.8777, first.longitude, 0.0001)
    }

    @Test
    fun testProgressPercentCalculation() {
        assertEquals(0, engine.getProgressPercent(0))
        val lastIndex = engine.routeWaypoints.size - 1
        assertEquals(100, engine.getProgressPercent(lastIndex))
    }

    @Test
    fun testManualStepAdvance() {
        assertEquals(0, engine.currentStep.value)
        val step1 = engine.advanceStep()
        assertEquals(1, step1)
        assertEquals(1, engine.currentStep.value)

        val step2 = engine.advanceStep()
        assertEquals(2, step2)
        assertEquals(2, engine.currentStep.value)
    }

    @Test
    fun testBearingCalculationComputesPositiveAngle() {
        val from = Coordinates(19.0760, 72.8777)
        val to = Coordinates(19.0880, 72.8950)
        val bearing = engine.calculateBearing(from, to)
        assertTrue(bearing in 0.0f..360.0f)
    }
}
