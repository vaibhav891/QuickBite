package com.quickbite.app.feature.customer.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quickbite.app.domain.repository.CartRepository
import com.quickbite.app.domain.repository.CartState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val cartRepository: CartRepository
) : ViewModel() {

    val cartState: StateFlow<CartState> = cartRepository.cartState
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = CartState()
        )

    fun onIncreaseQuantity(itemId: String) {
        val item = cartState.value.items.find { it.menuItem.id == itemId } ?: return
        cartRepository.updateQuantity(itemId, item.quantity + 1)
    }

    fun onDecreaseQuantity(itemId: String) {
        val item = cartState.value.items.find { it.menuItem.id == itemId } ?: return
        cartRepository.updateQuantity(itemId, item.quantity - 1)
    }

    fun onRemoveItem(itemId: String) {
        cartRepository.removeItem(itemId)
    }

    fun onClearCart() {
        cartRepository.clearCart()
    }
}
