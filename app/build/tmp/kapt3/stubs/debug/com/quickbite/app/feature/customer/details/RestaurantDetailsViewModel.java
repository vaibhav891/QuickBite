package com.quickbite.app.feature.customer.details;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000fJ\u000e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\rJ\u000e\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u000fJ\u000e\u0010 \u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u000fJ\u000e\u0010!\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u000fR\"\u0010\t\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\""}, d2 = {"Lcom/quickbite/app/feature/customer/details/RestaurantDetailsViewModel;", "Landroidx/lifecycle/ViewModel;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "restaurantRepository", "Lcom/quickbite/app/domain/repository/RestaurantRepository;", "cartRepository", "Lcom/quickbite/app/domain/repository/CartRepository;", "(Landroidx/lifecycle/SavedStateHandle;Lcom/quickbite/app/domain/repository/RestaurantRepository;Lcom/quickbite/app/domain/repository/CartRepository;)V", "_dialogState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlin/Pair;", "", "Lcom/quickbite/app/domain/model/MenuItem;", "_selectedCategory", "", "restaurantId", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/quickbite/app/feature/customer/details/DetailsUiState;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "confirmClearAndAdd", "", "dismissDialog", "getQuantityInCart", "", "itemId", "onAddItem", "item", "onCategorySelected", "category", "onDecreaseQuantity", "onIncreaseQuantity", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class RestaurantDetailsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.quickbite.app.domain.repository.RestaurantRepository restaurantRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.quickbite.app.domain.repository.CartRepository cartRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String restaurantId = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _selectedCategory = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<kotlin.Pair<java.lang.Boolean, com.quickbite.app.domain.model.MenuItem>> _dialogState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.quickbite.app.feature.customer.details.DetailsUiState> uiState = null;
    
    @javax.inject.Inject()
    public RestaurantDetailsViewModel(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.SavedStateHandle savedStateHandle, @org.jetbrains.annotations.NotNull()
    com.quickbite.app.domain.repository.RestaurantRepository restaurantRepository, @org.jetbrains.annotations.NotNull()
    com.quickbite.app.domain.repository.CartRepository cartRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.quickbite.app.feature.customer.details.DetailsUiState> getUiState() {
        return null;
    }
    
    public final void onCategorySelected(@org.jetbrains.annotations.NotNull()
    java.lang.String category) {
    }
    
    public final void onAddItem(@org.jetbrains.annotations.NotNull()
    com.quickbite.app.domain.model.MenuItem item) {
    }
    
    public final void onIncreaseQuantity(@org.jetbrains.annotations.NotNull()
    java.lang.String itemId) {
    }
    
    public final void onDecreaseQuantity(@org.jetbrains.annotations.NotNull()
    java.lang.String itemId) {
    }
    
    public final void confirmClearAndAdd() {
    }
    
    public final void dismissDialog() {
    }
    
    public final int getQuantityInCart(@org.jetbrains.annotations.NotNull()
    java.lang.String itemId) {
        return 0;
    }
}