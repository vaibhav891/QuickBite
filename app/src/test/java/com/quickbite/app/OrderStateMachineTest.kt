package com.quickbite.app

import com.quickbite.app.domain.model.OrderStatus
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class OrderStateMachineTest {

    @Test
    fun testValidHappyPathOrderLifecycleProgression() {
        // PLACED -> ACCEPTED
        assertTrue(OrderStatus.PLACED.canTransitionTo(OrderStatus.ACCEPTED))

        // ACCEPTED -> PREPARING
        assertTrue(OrderStatus.ACCEPTED.canTransitionTo(OrderStatus.PREPARING))

        // PREPARING -> READY_FOR_PICKUP
        assertTrue(OrderStatus.PREPARING.canTransitionTo(OrderStatus.READY_FOR_PICKUP))

        // READY_FOR_PICKUP -> PICKED_UP
        assertTrue(OrderStatus.READY_FOR_PICKUP.canTransitionTo(OrderStatus.PICKED_UP))

        // PICKED_UP -> DELIVERED
        assertTrue(OrderStatus.PICKED_UP.canTransitionTo(OrderStatus.DELIVERED))
    }

    @Test
    fun testOrderRejectionAndCancellationTransitions() {
        // PLACED can be rejected by restaurant
        assertTrue(OrderStatus.PLACED.canTransitionTo(OrderStatus.REJECTED))

        // PLACED can be cancelled by customer
        assertTrue(OrderStatus.PLACED.canTransitionTo(OrderStatus.CANCELLED))

        // ACCEPTED can be cancelled
        assertTrue(OrderStatus.ACCEPTED.canTransitionTo(OrderStatus.CANCELLED))

        // Terminal states cannot transition to anything
        assertTrue(OrderStatus.DELIVERED.isTerminal())
        assertTrue(OrderStatus.REJECTED.isTerminal())
        assertTrue(OrderStatus.CANCELLED.isTerminal())

        assertTrue(OrderStatus.DELIVERED.allowedNextStatuses().isEmpty())
        assertTrue(OrderStatus.REJECTED.allowedNextStatuses().isEmpty())
        assertTrue(OrderStatus.CANCELLED.allowedNextStatuses().isEmpty())
    }

    @Test
    fun testInvalidTransitionsAreDisallowed() {
        // Cannot skip states (e.g. PLACED -> DELIVERED)
        assertFalse(OrderStatus.PLACED.canTransitionTo(OrderStatus.DELIVERED))
        assertFalse(OrderStatus.PLACED.canTransitionTo(OrderStatus.READY_FOR_PICKUP))
        assertFalse(OrderStatus.PLACED.canTransitionTo(OrderStatus.PICKED_UP))

        // Cannot transition backwards (e.g. DELIVERED -> PREPARING)
        assertFalse(OrderStatus.DELIVERED.canTransitionTo(OrderStatus.PREPARING))
        assertFalse(OrderStatus.PICKED_UP.canTransitionTo(OrderStatus.ACCEPTED))
        assertFalse(OrderStatus.READY_FOR_PICKUP.canTransitionTo(OrderStatus.PLACED))

        // Cannot reject after food is already ready or picked up
        assertFalse(OrderStatus.PREPARING.canTransitionTo(OrderStatus.REJECTED))
        assertFalse(OrderStatus.READY_FOR_PICKUP.canTransitionTo(OrderStatus.REJECTED))
        assertFalse(OrderStatus.PICKED_UP.canTransitionTo(OrderStatus.REJECTED))
    }
}
