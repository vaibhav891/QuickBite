package com.quickbite.app.feature.restaurant.dashboard;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\tJ\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\tJ\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\tJ\u000e\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u000bJ\u0016\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\tJ,\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\t2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\tH\u0002R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f\u00a8\u0006!"}, d2 = {"Lcom/quickbite/app/feature/restaurant/dashboard/RestaurantDashboardViewModel;", "Landroidx/lifecycle/ViewModel;", "orderRepository", "Lcom/quickbite/app/domain/repository/OrderRepository;", "authRepository", "Lcom/quickbite/app/domain/repository/AuthRepository;", "(Lcom/quickbite/app/domain/repository/OrderRepository;Lcom/quickbite/app/domain/repository/AuthRepository;)V", "_actionError", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_selectedTab", "", "selectedTab", "Lkotlinx/coroutines/flow/StateFlow;", "getSelectedTab", "()Lkotlinx/coroutines/flow/StateFlow;", "uiState", "Lcom/quickbite/app/feature/restaurant/dashboard/RestaurantDashboardUiState;", "getUiState", "acceptOrder", "", "orderId", "markPreparing", "markReadyForPickup", "onTabSelected", "tabIndex", "rejectOrder", "reason", "transitionOrder", "newStatus", "Lcom/quickbite/app/domain/model/OrderStatus;", "note", "rejectReason", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class RestaurantDashboardViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.quickbite.app.domain.repository.OrderRepository orderRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.quickbite.app.domain.repository.AuthRepository authRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _selectedTab = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> selectedTab = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _actionError = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.quickbite.app.feature.restaurant.dashboard.RestaurantDashboardUiState> uiState = null;
    
    @javax.inject.Inject()
    public RestaurantDashboardViewModel(@org.jetbrains.annotations.NotNull()
    com.quickbite.app.domain.repository.OrderRepository orderRepository, @org.jetbrains.annotations.NotNull()
    com.quickbite.app.domain.repository.AuthRepository authRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getSelectedTab() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.quickbite.app.feature.restaurant.dashboard.RestaurantDashboardUiState> getUiState() {
        return null;
    }
    
    public final void onTabSelected(int tabIndex) {
    }
    
    public final void acceptOrder(@org.jetbrains.annotations.NotNull()
    java.lang.String orderId) {
    }
    
    public final void rejectOrder(@org.jetbrains.annotations.NotNull()
    java.lang.String orderId, @org.jetbrains.annotations.NotNull()
    java.lang.String reason) {
    }
    
    public final void markPreparing(@org.jetbrains.annotations.NotNull()
    java.lang.String orderId) {
    }
    
    public final void markReadyForPickup(@org.jetbrains.annotations.NotNull()
    java.lang.String orderId) {
    }
    
    private final void transitionOrder(java.lang.String orderId, com.quickbite.app.domain.model.OrderStatus newStatus, java.lang.String note, java.lang.String rejectReason) {
    }
}