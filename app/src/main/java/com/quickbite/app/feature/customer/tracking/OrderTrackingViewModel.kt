package com.quickbite.app.feature.customer.tracking

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quickbite.app.core.location.Coordinates
import com.quickbite.app.domain.model.Delivery
import com.quickbite.app.domain.model.Order
import com.quickbite.app.domain.repository.DeliveryRepository
import com.quickbite.app.domain.repository.OrderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

data class TrackingUiState(
    val order: Order? = null,
    val delivery: Delivery? = null,
    val waypoints: List<Coordinates> = emptyList(),
    val isAutoSimulating: Boolean = false,
    val isLoading: Boolean = true
)

@HiltViewModel
class OrderTrackingViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val orderRepository: OrderRepository,
    private val deliveryRepository: DeliveryRepository
) : ViewModel() {

    private val orderId: String = checkNotNull(savedStateHandle["orderId"])

    val uiState: StateFlow<TrackingUiState> = combine(
        orderRepository.getOrderById(orderId),
        deliveryRepository.getDelivery(orderId),
        deliveryRepository.isSimulating
    ) { order, delivery, isSimulating ->
        TrackingUiState(
            order = order,
            delivery = delivery,
            waypoints = deliveryRepository.getRouteWaypoints(),
            isAutoSimulating = isSimulating,
            isLoading = order == null
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = TrackingUiState()
    )

    fun onAdvanceSimulationStep() {
        viewModelScope.launch {
            deliveryRepository.advanceSimulationStep(orderId)
        }
    }

    fun onToggleAutoSimulation() {
        if (uiState.value.isAutoSimulating) {
            deliveryRepository.stopAutoSimulation()
        } else {
            deliveryRepository.startAutoSimulation(orderId)
        }
    }

    override fun onCleared() {
        super.onCleared()
        deliveryRepository.stopAutoSimulation()
    }
}
