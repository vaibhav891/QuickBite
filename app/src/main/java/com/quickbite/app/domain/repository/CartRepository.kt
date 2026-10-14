package com.quickbite.app.domain.repository

import com.quickbite.app.domain.model.CartItem
import com.quickbite.app.domain.model.MenuItem
import com.quickbite.app.domain.model.Restaurant
import kotlinx.coroutines.flow.StateFlow

data class CartState(
    val restaurant: Restaurant? = null,
    val items: List<CartItem> = emptyList(),
    val subtotalMinor: Long = 0L,
    val deliveryFeeMinor: Long = 0L,
    val taxMinor: Long = 0L,
    val totalMinor: Long = 0L
) {
    val totalItemCount: Int get() = items.sumOf { it.quantity }
    val isEmpty: Boolean get() = items.isEmpty()
}

interface CartRepository {
    val cartState: StateFlow<CartState>
    fun addItem(restaurant: Restaurant, item: MenuItem): Boolean
    fun updateQuantity(itemId: String, quantity: Int)
    fun removeItem(itemId: String)
    fun clearCart()
}
