package com.quickbite.app.feature.customer.discovery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

data class DiscoveryUiState(
    val restaurants: List<Restaurant> = emptyList(),
    val filteredRestaurants: List<Restaurant> = emptyList(),
    val categories: List<String> = emptyList(),
    val selectedCategory: String = "All",
    val searchQuery: String = "",
    val isLoading: Boolean = false,
    val cartState: CartState = CartState()
)

@HiltViewModel
class RestaurantDiscoveryViewModel @Inject constructor(
    private val restaurantRepository: RestaurantRepository,
    private val cartRepository: CartRepository
) : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _selectedCategory = MutableStateFlow("All")
    val selectedCategory: StateFlow<String> = _selectedCategory.asStateFlow()

    private val _categories = MutableStateFlow(restaurantRepository.getCuisineCategories())

    val uiState: StateFlow<DiscoveryUiState> = combine(
        restaurantRepository.getRestaurants(),
        _selectedCategory,
        _searchQuery,
        cartRepository.cartState
    ) { restaurants, category, query, cart ->
        val filtered = restaurants.filter { rest ->
            val matchesCategory = if (category == "All") true else {
                rest.cuisineTypes.any { it.equals(category, ignoreCase = true) }
            }
            val matchesQuery = if (query.isBlank()) true else {
                rest.name.contains(query, ignoreCase = true) ||
                rest.cuisineTypes.any { it.contains(query, ignoreCase = true) }
            }
            matchesCategory && matchesQuery
        }

        DiscoveryUiState(
            restaurants = restaurants,
            filteredRestaurants = filtered,
            categories = _categories.value,
            selectedCategory = category,
            searchQuery = query,
            isLoading = false,
            cartState = cart
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = DiscoveryUiState(isLoading = true)
    )

    fun onSearchQueryChanged(query: String) {
        _searchQuery.value = query
    }

    fun onCategorySelected(category: String) {
        _selectedCategory.value = category
    }

    fun seedDatabase() {
        viewModelScope.launch {
            restaurantRepository.seedFirestoreIfEmpty()
        }
    }
}
