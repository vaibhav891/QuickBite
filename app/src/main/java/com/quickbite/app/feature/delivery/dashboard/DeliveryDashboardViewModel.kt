package com.quickbite.app.feature.delivery.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quickbite.app.core.common.Constants
import com.quickbite.app.domain.model.Delivery
import com.quickbite.app.domain.model.Order
import com.quickbite.app.domain.model.OrderStatus
import com.quickbite.app.domain.repository.AuthRepository
import com.quickbite.app.domain.repository.DeliveryRepository
import com.quickbite.app.domain.repository.OrderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

data class DeliveryDashboardUiState(
    val availableOrders: List<Order> = emptyList(),
    val myActiveOrders: List<Order> = emptyList(),
    val myCompletedOrders: List<Order> = emptyList(),
    val selectedTab: Int = 0,
    val isSimulating: Boolean = false,
    val isLoading: Boolean = false
)

@HiltViewModel
class DeliveryDashboardViewModel @Inject constructor(
    private val orderRepository: OrderRepository,
    private val deliveryRepository: DeliveryRepository,
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _selectedTab = MutableStateFlow(0)
    val selectedTab: StateFlow<Int> = _selectedTab.asStateFlow()

    val uiState: StateFlow<DeliveryDashboardUiState> = authRepository.currentUser
        .flatMapLatest { user ->
            val riderId = user.deliveryPartnerId ?: Constants.DEMO_RIDER_ID
            combine(
                orderRepository.getAvailableDeliveries(),
                orderRepository.getAssignedDeliveries(riderId),
                deliveryRepository.isSimulating,
                _selectedTab
            ) { available, assigned, isSimulating, tab ->
                val active = assigned.filter { it.status != OrderStatus.DELIVERED }
                val completed = assigned.filter { it.status == OrderStatus.DELIVERED }

                DeliveryDashboardUiState(
                    availableOrders = available,
                    myActiveOrders = active,
                    myCompletedOrders = completed,
                    selectedTab = tab,
                    isSimulating = isSimulating,
                    isLoading = false
                )
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = DeliveryDashboardUiState(isLoading = true)
        )

    fun onTabSelected(tab: Int) {
        _selectedTab.value = tab
    }

    fun claimOrder(orderId: String) {
        viewModelScope.launch {
            val user = authRepository.currentUser.value
            orderRepository.claimDelivery(
                orderId = orderId,
                deliveryPartnerId = user.id,
                deliveryPartnerName = user.name
            )
            // Switch to Active Tab
            _selectedTab.value = 1
        }
    }

    fun markPickedUp(orderId: String) {
        viewModelScope.launch {
            val user = authRepository.currentUser.value
            orderRepository.updateOrderStatus(
                orderId = orderId,
                newStatus = OrderStatus.PICKED_UP,
                actorId = user.id,
                actorRole = "DELIVERY_PARTNER",
                note = "Courier picked up parcel from restaurant"
            )
        }
    }

    fun advanceSimulation(orderId: String) {
        viewModelScope.launch {
            val result = deliveryRepository.advanceSimulationStep(orderId)
            val updatedDelivery = result.getOrNull()
            if (updatedDelivery != null && updatedDelivery.routeProgressPercent >= 100) {
                markDelivered(orderId)
            }
        }
    }

    fun toggleAutoSimulation(orderId: String) {
        if (uiState.value.isSimulating) {
            deliveryRepository.stopAutoSimulation()
        } else {
            deliveryRepository.startAutoSimulation(orderId)
        }
    }

    fun markDelivered(orderId: String) {
        viewModelScope.launch {
            val user = authRepository.currentUser.value
            deliveryRepository.markDelivered(orderId)
            orderRepository.updateOrderStatus(
                orderId = orderId,
                newStatus = OrderStatus.DELIVERED,
                actorId = user.id,
                actorRole = "DELIVERY_PARTNER",
                note = "Order handed over to customer successfully"
            )
        }
    }
}
