package com.quickbite.app.feature.delivery.dashboard;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u000bJ\u000e\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f\u00a8\u0006\u001d"}, d2 = {"Lcom/quickbite/app/feature/delivery/dashboard/DeliveryDashboardViewModel;", "Landroidx/lifecycle/ViewModel;", "orderRepository", "Lcom/quickbite/app/domain/repository/OrderRepository;", "deliveryRepository", "Lcom/quickbite/app/domain/repository/DeliveryRepository;", "authRepository", "Lcom/quickbite/app/domain/repository/AuthRepository;", "(Lcom/quickbite/app/domain/repository/OrderRepository;Lcom/quickbite/app/domain/repository/DeliveryRepository;Lcom/quickbite/app/domain/repository/AuthRepository;)V", "_selectedTab", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "selectedTab", "Lkotlinx/coroutines/flow/StateFlow;", "getSelectedTab", "()Lkotlinx/coroutines/flow/StateFlow;", "uiState", "Lcom/quickbite/app/feature/delivery/dashboard/DeliveryDashboardUiState;", "getUiState", "advanceSimulation", "", "orderId", "", "claimOrder", "markDelivered", "markPickedUp", "onTabSelected", "tab", "toggleAutoSimulation", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class DeliveryDashboardViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.quickbite.app.domain.repository.OrderRepository orderRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.quickbite.app.domain.repository.DeliveryRepository deliveryRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.quickbite.app.domain.repository.AuthRepository authRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _selectedTab = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> selectedTab = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.quickbite.app.feature.delivery.dashboard.DeliveryDashboardUiState> uiState = null;
    
    @javax.inject.Inject()
    public DeliveryDashboardViewModel(@org.jetbrains.annotations.NotNull()
    com.quickbite.app.domain.repository.OrderRepository orderRepository, @org.jetbrains.annotations.NotNull()
    com.quickbite.app.domain.repository.DeliveryRepository deliveryRepository, @org.jetbrains.annotations.NotNull()
    com.quickbite.app.domain.repository.AuthRepository authRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getSelectedTab() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.quickbite.app.feature.delivery.dashboard.DeliveryDashboardUiState> getUiState() {
        return null;
    }
    
    public final void onTabSelected(int tab) {
    }
    
    public final void claimOrder(@org.jetbrains.annotations.NotNull()
    java.lang.String orderId) {
    }
    
    public final void markPickedUp(@org.jetbrains.annotations.NotNull()
    java.lang.String orderId) {
    }
    
    public final void advanceSimulation(@org.jetbrains.annotations.NotNull()
    java.lang.String orderId) {
    }
    
    public final void toggleAutoSimulation(@org.jetbrains.annotations.NotNull()
    java.lang.String orderId) {
    }
    
    public final void markDelivered(@org.jetbrains.annotations.NotNull()
    java.lang.String orderId) {
    }
}