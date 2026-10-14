package com.quickbite.app.feature.customer.checkout

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quickbite.app.core.common.Constants
import com.quickbite.app.domain.model.Order
import com.quickbite.app.domain.repository.AuthRepository
import com.quickbite.app.domain.repository.CartRepository
import com.quickbite.app.domain.repository.CartState
import com.quickbite.app.domain.repository.OrderRepository
import com.quickbite.app.domain.repository.PaymentDraftResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

enum class PaymentOption {
    DEMO_QUICK_PAY,
    STRIPE_TEST_CARD
}

data class CheckoutUiState(
    val cartState: CartState = CartState(),
    val deliveryAddress: String = Constants.DEMO_DELIVERY_ADDRESS,
    val selectedPaymentOption: PaymentOption = PaymentOption.DEMO_QUICK_PAY,
    val draft: PaymentDraftResult? = null,
    val isLoading: Boolean = false,
    val orderPlaced: Order? = null,
    val errorMessage: String? = null
)

@HiltViewModel
class CheckoutViewModel @Inject constructor(
    private val cartRepository: CartRepository,
    private val orderRepository: OrderRepository,
    private val authRepository: AuthRepository
) : ViewModel() {

    val cartState: StateFlow<CartState> = cartRepository.cartState
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = CartState()
        )

    private val _uiState = MutableStateFlow(CheckoutUiState())
    val uiState: StateFlow<CheckoutUiState> = _uiState.asStateFlow()

    init {
        _uiState.value = _uiState.value.copy(cartState = cartRepository.cartState.value)
    }

    fun onPaymentOptionSelected(option: PaymentOption) {
        _uiState.value = _uiState.value.copy(selectedPaymentOption = option)
    }

    fun onAddressChanged(address: String) {
        _uiState.value = _uiState.value.copy(deliveryAddress = address)
    }

    fun placeOrder() {
        val cart = cartRepository.cartState.value
        val restaurant = cart.restaurant ?: return
        if (cart.items.isEmpty()) return

        _uiState.value = _uiState.value.copy(isLoading = true, errorMessage = null)

        viewModelScope.launch {
            // 1. Create Checkout Draft with Server Price Recalculation
            val draftResult = orderRepository.createCheckoutDraft(
                restaurantId = restaurant.id,
                restaurantName = restaurant.name,
                items = cart.items,
                deliveryAddress = _uiState.value.deliveryAddress
            )

            if (draftResult.isFailure) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    errorMessage = draftResult.exceptionOrNull()?.message ?: "Failed to validate order with server."
                )
                return@launch
            }

            val draft = draftResult.getOrThrow()
            _uiState.value = _uiState.value.copy(draft = draft)

            // 2. Authoritative Order Placement
            val user = authRepository.currentUser.value
            val isMock = _uiState.value.selectedPaymentOption == PaymentOption.DEMO_QUICK_PAY

            val orderResult = orderRepository.confirmAndPlaceOrder(
                draft = draft,
                customerId = user.id,
                customerName = user.name,
                restaurantId = restaurant.id,
                restaurantName = restaurant.name,
                items = cart.items,
                deliveryAddress = _uiState.value.deliveryAddress,
                isMockPayment = isMock
            )

            if (orderResult.isSuccess) {
                val createdOrder = orderResult.getOrThrow()
                cartRepository.clearCart()
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    orderPlaced = createdOrder
                )
            } else {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    errorMessage = orderResult.exceptionOrNull()?.message ?: "Order confirmation failed."
                )
            }
        }
    }
}
