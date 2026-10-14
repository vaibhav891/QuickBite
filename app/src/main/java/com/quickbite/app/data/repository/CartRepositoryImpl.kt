package com.quickbite.app.data.repository

import com.quickbite.app.core.common.CurrencyUtils
import com.quickbite.app.domain.model.CartItem
import com.quickbite.app.domain.model.MenuItem
import com.quickbite.app.domain.model.Restaurant
import com.quickbite.app.domain.repository.CartRepository
import com.quickbite.app.domain.repository.CartState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CartRepositoryImpl @Inject constructor() : CartRepository {

    private val _cartState = MutableStateFlow(CartState())
    override val cartState: StateFlow<CartState> = _cartState.asStateFlow()

    override fun addItem(restaurant: Restaurant, item: MenuItem): Boolean {
        val current = _cartState.value

        // Check single restaurant restriction
        if (current.restaurant != null && current.restaurant.id != restaurant.id) {
            // Cannot mix restaurants in a single order
            return false
        }

        val existingIndex = current.items.indexOfFirst { it.menuItem.id == item.id }
        val updatedItems = if (existingIndex >= 0) {
            current.items.mapIndexed { index, cartItem ->
                if (index == existingIndex) {
                    cartItem.copy(quantity = cartItem.quantity + 1)
                } else cartItem
            }
        } else {
            current.items + CartItem(menuItem = item, quantity = 1)
        }

        recalculate(restaurant, updatedItems)
        return true
    }

    override fun updateQuantity(itemId: String, quantity: Int) {
        val current = _cartState.value
        val restaurant = current.restaurant ?: return

        val updatedItems = if (quantity <= 0) {
            current.items.filterNot { it.menuItem.id == itemId }
        } else {
            current.items.map {
                if (it.menuItem.id == itemId) it.copy(quantity = quantity) else it
            }
        }

        if (updatedItems.isEmpty()) {
            clearCart()
        } else {
            recalculate(restaurant, updatedItems)
        }
    }

    override fun removeItem(itemId: String) {
        updateQuantity(itemId, 0)
    }

    override fun clearCart() {
        _cartState.value = CartState()
    }

    private fun recalculate(restaurant: Restaurant, items: List<CartItem>) {
        val subtotal = items.sumOf { it.totalPriceMinor }
        val deliveryFee = restaurant.deliveryFeeMinor
        val tax = CurrencyUtils.calculateTaxMinor(subtotal)
        val total = subtotal + deliveryFee + tax

        _cartState.value = CartState(
            restaurant = restaurant,
            items = items,
            subtotalMinor = subtotal,
            deliveryFeeMinor = deliveryFee,
            taxMinor = tax,
            totalMinor = total
        )
    }
}
