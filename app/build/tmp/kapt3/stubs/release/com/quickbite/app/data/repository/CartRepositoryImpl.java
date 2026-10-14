package com.quickbite.app.data.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u001c"}, d2 = {"Lcom/quickbite/app/data/repository/CartRepositoryImpl;", "Lcom/quickbite/app/domain/repository/CartRepository;", "()V", "_cartState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/quickbite/app/domain/repository/CartState;", "cartState", "Lkotlinx/coroutines/flow/StateFlow;", "getCartState", "()Lkotlinx/coroutines/flow/StateFlow;", "addItem", "", "restaurant", "Lcom/quickbite/app/domain/model/Restaurant;", "item", "Lcom/quickbite/app/domain/model/MenuItem;", "clearCart", "", "recalculate", "items", "", "Lcom/quickbite/app/domain/model/CartItem;", "removeItem", "itemId", "", "updateQuantity", "quantity", "", "app_release"})
public final class CartRepositoryImpl implements com.quickbite.app.domain.repository.CartRepository {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.quickbite.app.domain.repository.CartState> _cartState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.quickbite.app.domain.repository.CartState> cartState = null;
    
    @javax.inject.Inject()
    public CartRepositoryImpl() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.StateFlow<com.quickbite.app.domain.repository.CartState> getCartState() {
        return null;
    }
    
    @java.lang.Override()
    public boolean addItem(@org.jetbrains.annotations.NotNull()
    com.quickbite.app.domain.model.Restaurant restaurant, @org.jetbrains.annotations.NotNull()
    com.quickbite.app.domain.model.MenuItem item) {
        return false;
    }
    
    @java.lang.Override()
    public void updateQuantity(@org.jetbrains.annotations.NotNull()
    java.lang.String itemId, int quantity) {
    }
    
    @java.lang.Override()
    public void removeItem(@org.jetbrains.annotations.NotNull()
    java.lang.String itemId) {
    }
    
    @java.lang.Override()
    public void clearCart() {
    }
    
    private final void recalculate(com.quickbite.app.domain.model.Restaurant restaurant, java.util.List<com.quickbite.app.domain.model.CartItem> items) {
    }
}