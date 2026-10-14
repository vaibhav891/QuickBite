package com.quickbite.app.feature.customer.history;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/quickbite/app/feature/customer/history/OrderHistoryViewModel;", "Landroidx/lifecycle/ViewModel;", "orderRepository", "Lcom/quickbite/app/domain/repository/OrderRepository;", "authRepository", "Lcom/quickbite/app/domain/repository/AuthRepository;", "(Lcom/quickbite/app/domain/repository/OrderRepository;Lcom/quickbite/app/domain/repository/AuthRepository;)V", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/quickbite/app/feature/customer/history/HistoryUiState;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class OrderHistoryViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.quickbite.app.domain.repository.OrderRepository orderRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.quickbite.app.domain.repository.AuthRepository authRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.quickbite.app.feature.customer.history.HistoryUiState> uiState = null;
    
    @javax.inject.Inject()
    public OrderHistoryViewModel(@org.jetbrains.annotations.NotNull()
    com.quickbite.app.domain.repository.OrderRepository orderRepository, @org.jetbrains.annotations.NotNull()
    com.quickbite.app.domain.repository.AuthRepository authRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.quickbite.app.feature.customer.history.HistoryUiState> getUiState() {
        return null;
    }
}