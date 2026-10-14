package com.quickbite.app

import com.quickbite.app.core.common.CurrencyUtils
import com.quickbite.app.data.repository.CartRepositoryImpl
import com.quickbite.app.domain.model.MenuItem
import com.quickbite.app.domain.model.Restaurant
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class CartCalculationTest {

    private lateinit var cartRepository: CartRepositoryImpl

    private val restaurantA = Restaurant(
        id = "rest_01",
        name = "Golden Dragon Asian Bistro",
        description = "Dim sum & noodles",
        cuisineTypes = listOf("Pan-Asian"),
        imageUrl = "",
        deliveryFeeMinor = 4900L // ₹49
    )

    private val restaurantB = Restaurant(
        id = "rest_02",
        name = "Bella Italia Trattoria",
        description = "Pizza & pasta",
        cuisineTypes = listOf("Italian"),
        imageUrl = "",
        deliveryFeeMinor = 3900L // ₹39
    )

    private val itemDumplings = MenuItem(
        id = "item_01",
        restaurantId = "rest_01",
        name = "Har Gow Dumplings",
        description = "Shrimp dumplings",
        priceMinor = 38000L, // ₹380
        imageUrl = "",
        category = "Dim Sum"
    )

    private val itemNoodles = MenuItem(
        id = "item_02",
        restaurantId = "rest_01",
        name = "Dan Dan Noodles",
        description = "Spicy noodles",
        priceMinor = 42000L, // ₹420
        imageUrl = "",
        category = "Noodles"
    )

    private val itemPizza = MenuItem(
        id = "item_03",
        restaurantId = "rest_02",
        name = "Margherita Pizza",
        description = "Wood-fired pizza",
        priceMinor = 49000L, // ₹490
        imageUrl = "",
        category = "Pizza"
    )

    @Before
    fun setUp() {
        cartRepository = CartRepositoryImpl()
    }

    @Test
    fun testEmptyCartInitialState() {
        val state = cartRepository.cartState.value
        assertTrue(state.isEmpty)
        assertEquals(0, state.totalItemCount)
        assertEquals(0L, state.totalMinor)
    }

    @Test
    fun testAddItemCalculatesSubtotalTaxAndTotalAccurately() {
        // Add 1 Har Gow (₹380)
        cartRepository.addItem(restaurantA, itemDumplings)

        val state = cartRepository.cartState.value
        assertEquals(1, state.totalItemCount)
        assertEquals(38000L, state.subtotalMinor) // ₹380
        assertEquals(4900L, state.deliveryFeeMinor) // ₹49

        // 5% tax on 38000 = 1900L (₹19)
        val expectedTax = CurrencyUtils.calculateTaxMinor(38000L)
        assertEquals(1900L, expectedTax)
        assertEquals(expectedTax, state.taxMinor)

        // Total = 38000 + 4900 + 1900 = 44800L (₹448.00)
        val expectedTotal = 38000L + 4900L + 1900L
        assertEquals(expectedTotal, state.totalMinor)
    }

    @Test
    fun testIncreasingQuantityUpdatesTotalsProperly() {
        cartRepository.addItem(restaurantA, itemDumplings)
        // Add second dumpling (Qty 2 -> ₹760)
        cartRepository.addItem(restaurantA, itemDumplings)

        val state = cartRepository.cartState.value
        assertEquals(2, state.totalItemCount)
        assertEquals(76000L, state.subtotalMinor) // ₹760

        // 5% tax on 76000 = 3800L (₹38)
        assertEquals(3800L, state.taxMinor)

        // Total = 76000 + 4900 + 3800 = 84700L (₹847.00)
        assertEquals(84700L, state.totalMinor)
    }

    @Test
    fun testMultipleDistinctItemsCalculation() {
        cartRepository.addItem(restaurantA, itemDumplings) // ₹380
        cartRepository.addItem(restaurantA, itemNoodles)   // ₹420

        val state = cartRepository.cartState.value
        assertEquals(2, state.totalItemCount)
        assertEquals(80000L, state.subtotalMinor) // ₹800

        // 5% tax on 80000 = 4000L (₹40)
        assertEquals(4000L, state.taxMinor)

        // Total = 80000 + 4900 + 4000 = 88900L (₹889.00)
        assertEquals(88900L, state.totalMinor)
    }

    @Test
    fun testSingleRestaurantRestrictionEnforced() {
        // Add item from restaurant A
        val successA = cartRepository.addItem(restaurantA, itemDumplings)
        assertTrue(successA)

        // Attempting to add item from restaurant B should be rejected
        val successB = cartRepository.addItem(restaurantB, itemPizza)
        assertFalse(successB)

        // Cart should still contain only restaurant A items
        assertEquals(restaurantA.id, cartRepository.cartState.value.restaurant?.id)
        assertEquals(1, cartRepository.cartState.value.totalItemCount)
    }

    @Test
    fun testDecreasingQuantityToZeroRemovesItem() {
        cartRepository.addItem(restaurantA, itemDumplings)
        assertEquals(1, cartRepository.cartState.value.totalItemCount)

        // Decrease to 0
        cartRepository.updateQuantity(itemDumplings.id, 0)
        assertTrue(cartRepository.cartState.value.isEmpty)
        assertEquals(0L, cartRepository.cartState.value.totalMinor)
    }
}
