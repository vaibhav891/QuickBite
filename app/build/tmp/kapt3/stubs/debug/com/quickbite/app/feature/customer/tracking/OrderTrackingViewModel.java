package com.quickbite.app.feature.customer.tracking;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\u0006\u0010\u0013\u001a\u00020\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/quickbite/app/feature/customer/tracking/OrderTrackingViewModel;", "Landroidx/lifecycle/ViewModel;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "orderRepository", "Lcom/quickbite/app/domain/repository/OrderRepository;", "deliveryRepository", "Lcom/quickbite/app/domain/repository/DeliveryRepository;", "(Landroidx/lifecycle/SavedStateHandle;Lcom/quickbite/app/domain/repository/OrderRepository;Lcom/quickbite/app/domain/repository/DeliveryRepository;)V", "orderId", "", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/quickbite/app/feature/customer/tracking/TrackingUiState;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "onAdvanceSimulationStep", "", "onCleared", "onToggleAutoSimulation", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class OrderTrackingViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.quickbite.app.domain.repository.OrderRepository orderRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.quickbite.app.domain.repository.DeliveryRepository deliveryRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String orderId = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.quickbite.app.feature.customer.tracking.TrackingUiState> uiState = null;
    
    @javax.inject.Inject()
    public OrderTrackingViewModel(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.SavedStateHandle savedStateHandle, @org.jetbrains.annotations.NotNull()
    com.quickbite.app.domain.repository.OrderRepository orderRepository, @org.jetbrains.annotations.NotNull()
    com.quickbite.app.domain.repository.DeliveryRepository deliveryRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.quickbite.app.feature.customer.tracking.TrackingUiState> getUiState() {
        return null;
    }
    
    public final void onAdvanceSimulationStep() {
    }
    
    public final void onToggleAutoSimulation() {
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
}