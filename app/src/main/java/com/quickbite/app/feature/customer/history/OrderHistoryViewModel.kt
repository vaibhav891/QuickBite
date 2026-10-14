package com.quickbite.app.feature.customer.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quickbite.app.domain.model.Order
import com.quickbite.app.domain.repository.AuthRepository
import com.quickbite.app.domain.repository.OrderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

data class HistoryUiState(
    val activeOrders: List<Order> = emptyList(),
    val pastOrders: List<Order> = emptyList(),
    val isLoading: Boolean = false
)

@HiltViewModel
class OrderHistoryViewModel @Inject constructor(
    private val orderRepository: OrderRepository,
    private val authRepository: AuthRepository
) : ViewModel() {

    val uiState: StateFlow<HistoryUiState> = authRepository.currentUser
        .flatMapLatest { user ->
            orderRepository.getOrdersForCustomer(user.id)
        }
        .map { orders ->
            val active = orders.filter { !it.status.isTerminal() }
            val past = orders.filter { it.status.isTerminal() }
            HistoryUiState(activeOrders = active, pastOrders = past, isLoading = false)
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = HistoryUiState(isLoading = true)
        )
}
