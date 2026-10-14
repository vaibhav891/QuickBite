package com.quickbite.app.feature.restaurant.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quickbite.app.core.common.Constants
import com.quickbite.app.domain.model.Order
import com.quickbite.app.domain.model.OrderStatus
import com.quickbite.app.domain.repository.AuthRepository
import com.quickbite.app.domain.repository.OrderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

data class RestaurantDashboardUiState(
    val newOrders: List<Order> = emptyList(),
    val preparingOrders: List<Order> = emptyList(),
    val readyOrders: List<Order> = emptyList(),
    val completedOrders: List<Order> = emptyList(),
    val selectedTab: Int = 0,
    val isLoading: Boolean = false,
    val actionError: String? = null
)

@HiltViewModel
class RestaurantDashboardViewModel @Inject constructor(
    private val orderRepository: OrderRepository,
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _selectedTab = MutableStateFlow(0)
    val selectedTab: StateFlow<Int> = _selectedTab.asStateFlow()

    private val _actionError = MutableStateFlow<String?>(null)

    val uiState: StateFlow<RestaurantDashboardUiState> = authRepository.currentUser
        .flatMapLatest { user ->
            val restaurantId = user.restaurantId ?: Constants.DEMO_RESTAURANT_ID
            orderRepository.getOrdersForRestaurant(restaurantId)
        }
        .map { orders ->
            val newOrders = orders.filter { it.status == OrderStatus.PLACED }
            val preparingOrders = orders.filter { it.status == OrderStatus.ACCEPTED || it.status == OrderStatus.PREPARING }
            val readyOrders = orders.filter { it.status == OrderStatus.READY_FOR_PICKUP }
            val completedOrders = orders.filter { it.status == OrderStatus.PICKED_UP || it.status == OrderStatus.DELIVERED }

            RestaurantDashboardUiState(
                newOrders = newOrders,
                preparingOrders = preparingOrders,
                readyOrders = readyOrders,
                completedOrders = completedOrders,
                selectedTab = _selectedTab.value,
                isLoading = false,
                actionError = _actionError.value
            )
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = RestaurantDashboardUiState(isLoading = true)
        )

    fun onTabSelected(tabIndex: Int) {
        _selectedTab.value = tabIndex
    }

    fun acceptOrder(orderId: String) {
        transitionOrder(orderId, OrderStatus.ACCEPTED, "Order accepted by kitchen")
    }

    fun rejectOrder(orderId: String, reason: String) {
        transitionOrder(orderId, OrderStatus.REJECTED, "Rejected: $reason", reason)
    }

    fun markPreparing(orderId: String) {
        transitionOrder(orderId, OrderStatus.PREPARING, "Chef started cooking")
    }

    fun markReadyForPickup(orderId: String) {
        transitionOrder(orderId, OrderStatus.READY_FOR_PICKUP, "Packed & ready for delivery rider")
    }

    private fun transitionOrder(
        orderId: String,
        newStatus: OrderStatus,
        note: String,
        rejectReason: String? = null
    ) {
        viewModelScope.launch {
            val user = authRepository.currentUser.value
            val result = orderRepository.updateOrderStatus(
                orderId = orderId,
                newStatus = newStatus,
                actorId = user.id,
                actorRole = "RESTAURANT",
                note = note,
                rejectReason = rejectReason
            )
            if (result.isFailure) {
                _actionError.value = result.exceptionOrNull()?.message
            } else {
                _actionError.value = null
            }
        }
    }
}
