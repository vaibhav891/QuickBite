package com.quickbite.app.feature.customer.checkout;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0014R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010\u00a8\u0006\u001b"}, d2 = {"Lcom/quickbite/app/feature/customer/checkout/CheckoutViewModel;", "Landroidx/lifecycle/ViewModel;", "cartRepository", "Lcom/quickbite/app/domain/repository/CartRepository;", "orderRepository", "Lcom/quickbite/app/domain/repository/OrderRepository;", "authRepository", "Lcom/quickbite/app/domain/repository/AuthRepository;", "(Lcom/quickbite/app/domain/repository/CartRepository;Lcom/quickbite/app/domain/repository/OrderRepository;Lcom/quickbite/app/domain/repository/AuthRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/quickbite/app/feature/customer/checkout/CheckoutUiState;", "cartState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/quickbite/app/domain/repository/CartState;", "getCartState", "()Lkotlinx/coroutines/flow/StateFlow;", "uiState", "getUiState", "onAddressChanged", "", "address", "", "onPaymentOptionSelected", "option", "Lcom/quickbite/app/feature/customer/checkout/PaymentOption;", "placeOrder", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class CheckoutViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.quickbite.app.domain.repository.CartRepository cartRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.quickbite.app.domain.repository.OrderRepository orderRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.quickbite.app.domain.repository.AuthRepository authRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.quickbite.app.domain.repository.CartState> cartState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.quickbite.app.feature.customer.checkout.CheckoutUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.quickbite.app.feature.customer.checkout.CheckoutUiState> uiState = null;
    
    @javax.inject.Inject()
    public CheckoutViewModel(@org.jetbrains.annotations.NotNull()
    com.quickbite.app.domain.repository.CartRepository cartRepository, @org.jetbrains.annotations.NotNull()
    com.quickbite.app.domain.repository.OrderRepository orderRepository, @org.jetbrains.annotations.NotNull()
    com.quickbite.app.domain.repository.AuthRepository authRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.quickbite.app.domain.repository.CartState> getCartState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.quickbite.app.feature.customer.checkout.CheckoutUiState> getUiState() {
        return null;
    }
    
    public final void onPaymentOptionSelected(@org.jetbrains.annotations.NotNull()
    com.quickbite.app.feature.customer.checkout.PaymentOption option) {
    }
    
    public final void onAddressChanged(@org.jetbrains.annotations.NotNull()
    java.lang.String address) {
    }
    
    public final void placeOrder() {
    }
}