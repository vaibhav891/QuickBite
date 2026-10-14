package com.quickbite.app.feature.customer.details;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Be\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u0010J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u0005H\u00c6\u0003J\t\u0010!\u001a\u00020\bH\u00c6\u0003J\t\u0010\"\u001a\u00020\u000bH\u00c6\u0003J\t\u0010#\u001a\u00020\rH\u00c6\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\t\u0010%\u001a\u00020\rH\u00c6\u0003Ji\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000f\u001a\u00020\rH\u00c6\u0001J\u0013\u0010\'\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010)\u001a\u00020*H\u00d6\u0001J\t\u0010+\u001a\u00020\bH\u00d6\u0001R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0015R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\t\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015\u00a8\u0006,"}, d2 = {"Lcom/quickbite/app/feature/customer/details/DetailsUiState;", "", "restaurant", "Lcom/quickbite/app/domain/model/Restaurant;", "menuItems", "", "Lcom/quickbite/app/domain/model/MenuItem;", "categories", "", "selectedCategory", "cartState", "Lcom/quickbite/app/domain/repository/CartState;", "showDifferentRestaurantDialog", "", "pendingItemToAdd", "isLoading", "(Lcom/quickbite/app/domain/model/Restaurant;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lcom/quickbite/app/domain/repository/CartState;ZLcom/quickbite/app/domain/model/MenuItem;Z)V", "getCartState", "()Lcom/quickbite/app/domain/repository/CartState;", "getCategories", "()Ljava/util/List;", "()Z", "getMenuItems", "getPendingItemToAdd", "()Lcom/quickbite/app/domain/model/MenuItem;", "getRestaurant", "()Lcom/quickbite/app/domain/model/Restaurant;", "getSelectedCategory", "()Ljava/lang/String;", "getShowDifferentRestaurantDialog", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class DetailsUiState {
    @org.jetbrains.annotations.Nullable()
    private final com.quickbite.app.domain.model.Restaurant restaurant = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.quickbite.app.domain.model.MenuItem> menuItems = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> categories = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String selectedCategory = null;
    @org.jetbrains.annotations.NotNull()
    private final com.quickbite.app.domain.repository.CartState cartState = null;
    private final boolean showDifferentRestaurantDialog = false;
    @org.jetbrains.annotations.Nullable()
    private final com.quickbite.app.domain.model.MenuItem pendingItemToAdd = null;
    private final boolean isLoading = false;
    
    public DetailsUiState(@org.jetbrains.annotations.Nullable()
    com.quickbite.app.domain.model.Restaurant restaurant, @org.jetbrains.annotations.NotNull()
    java.util.List<com.quickbite.app.domain.model.MenuItem> menuItems, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> categories, @org.jetbrains.annotations.NotNull()
    java.lang.String selectedCategory, @org.jetbrains.annotations.NotNull()
    com.quickbite.app.domain.repository.CartState cartState, boolean showDifferentRestaurantDialog, @org.jetbrains.annotations.Nullable()
    com.quickbite.app.domain.model.MenuItem pendingItemToAdd, boolean isLoading) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.quickbite.app.domain.model.Restaurant getRestaurant() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.quickbite.app.domain.model.MenuItem> getMenuItems() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getCategories() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSelectedCategory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.quickbite.app.domain.repository.CartState getCartState() {
        return null;
    }
    
    public final boolean getShowDifferentRestaurantDialog() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.quickbite.app.domain.model.MenuItem getPendingItemToAdd() {
        return null;
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    public DetailsUiState() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.quickbite.app.domain.model.Restaurant component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.quickbite.app.domain.model.MenuItem> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.quickbite.app.domain.repository.CartState component5() {
        return null;
    }
    
    public final boolean component6() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.quickbite.app.domain.model.MenuItem component7() {
        return null;
    }
    
    public final boolean component8() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.quickbite.app.feature.customer.details.DetailsUiState copy(@org.jetbrains.annotations.Nullable()
    com.quickbite.app.domain.model.Restaurant restaurant, @org.jetbrains.annotations.NotNull()
    java.util.List<com.quickbite.app.domain.model.MenuItem> menuItems, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> categories, @org.jetbrains.annotations.NotNull()
    java.lang.String selectedCategory, @org.jetbrains.annotations.NotNull()
    com.quickbite.app.domain.repository.CartState cartState, boolean showDifferentRestaurantDialog, @org.jetbrains.annotations.Nullable()
    com.quickbite.app.domain.model.MenuItem pendingItemToAdd, boolean isLoading) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}