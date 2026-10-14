package com.quickbite.app.feature.customer.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quickbite.app.domain.model.MenuItem
import com.quickbite.app.domain.model.Restaurant
import com.quickbite.app.domain.repository.CartRepository
import com.quickbite.app.domain.repository.CartState
import com.quickbite.app.domain.repository.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

data class DetailsUiState(
    val restaurant: Restaurant? = null,
    val menuItems: List<MenuItem> = emptyList(),
    val categories: List<String> = emptyList(),
    val selectedCategory: String = "All",
    val cartState: CartState = CartState(),
    val showDifferentRestaurantDialog: Boolean = false,
    val pendingItemToAdd: MenuItem? = null,
    val isLoading: Boolean = true
)

@HiltViewModel
class RestaurantDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val restaurantRepository: RestaurantRepository,
    private val cartRepository: CartRepository
) : ViewModel() {

    private val restaurantId: String = checkNotNull(savedStateHandle["restaurantId"])

    private val _selectedCategory = MutableStateFlow("All")
    private val _dialogState = MutableStateFlow<Pair<Boolean, MenuItem?>>(Pair(false, null))

    val uiState: StateFlow<DetailsUiState> = combine(
        restaurantRepository.getRestaurantById(restaurantId),
        restaurantRepository.getMenuItems(restaurantId),
        _selectedCategory,
        cartRepository.cartState,
        _dialogState
    ) { restaurant, menuItems, category, cart, dialog ->
        val categories = listOf("All") + menuItems.map { it.category }.distinct()
        val filtered = if (category == "All") menuItems else menuItems.filter { it.category == category }

        DetailsUiState(
            restaurant = restaurant,
            menuItems = filtered,
            categories = categories,
            selectedCategory = category,
            cartState = cart,
            showDifferentRestaurantDialog = dialog.first,
            pendingItemToAdd = dialog.second,
            isLoading = restaurant == null
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = DetailsUiState()
    )

    fun onCategorySelected(category: String) {
        _selectedCategory.value = category
    }

    fun onAddItem(item: MenuItem) {
        val currentRestaurant = uiState.value.restaurant ?: return
        val success = cartRepository.addItem(currentRestaurant, item)
        if (!success) {
            // Cart contains items from another restaurant
            _dialogState.value = Pair(true, item)
        }
    }

    fun onIncreaseQuantity(itemId: String) {
        val currentQty = getQuantityInCart(itemId)
        cartRepository.updateQuantity(itemId, currentQty + 1)
    }

    fun onDecreaseQuantity(itemId: String) {
        val currentQty = getQuantityInCart(itemId)
        cartRepository.updateQuantity(itemId, currentQty - 1)
    }

    fun confirmClearAndAdd() {
        val item = _dialogState.value.second
        val restaurant = uiState.value.restaurant
        cartRepository.clearCart()
        _dialogState.value = Pair(false, null)
        if (restaurant != null && item != null) {
            cartRepository.addItem(restaurant, item)
        }
    }

    fun dismissDialog() {
        _dialogState.value = Pair(false, null)
    }

    fun getQuantityInCart(itemId: String): Int {
        return uiState.value.cartState.items.find { it.menuItem.id == itemId }?.quantity ?: 0
    }
}
