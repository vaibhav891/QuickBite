package com.quickbite.app.feature.customer.cart;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0011"}, d2 = {"Lcom/quickbite/app/feature/customer/cart/CartViewModel;", "Landroidx/lifecycle/ViewModel;", "cartRepository", "Lcom/quickbite/app/domain/repository/CartRepository;", "(Lcom/quickbite/app/domain/repository/CartRepository;)V", "cartState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/quickbite/app/domain/repository/CartState;", "getCartState", "()Lkotlinx/coroutines/flow/StateFlow;", "onClearCart", "", "onDecreaseQuantity", "itemId", "", "onIncreaseQuantity", "onRemoveItem", "app_release"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class CartViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.quickbite.app.domain.repository.CartRepository cartRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.quickbite.app.domain.repository.CartState> cartState = null;
    
    @javax.inject.Inject()
    public CartViewModel(@org.jetbrains.annotations.NotNull()
    com.quickbite.app.domain.repository.CartRepository cartRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.quickbite.app.domain.repository.CartState> getCartState() {
        return null;
    }
    
    public final void onIncreaseQuantity(@org.jetbrains.annotations.NotNull()
    java.lang.String itemId) {
    }
    
    public final void onDecreaseQuantity(@org.jetbrains.annotations.NotNull()
    java.lang.String itemId) {
    }
    
    public final void onRemoveItem(@org.jetbrains.annotations.NotNull()
    java.lang.String itemId) {
    }
    
    public final void onClearCart() {
    }
}