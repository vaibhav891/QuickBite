package com.quickbite.app.feature.customer.discovery;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B]\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u000bH\u00c6\u0003J\t\u0010\u001f\u001a\u00020\rH\u00c6\u0003Ja\u0010 \u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u00c6\u0001J\u0013\u0010!\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010#\u001a\u00020$H\u00d6\u0001J\t\u0010%\u001a\u00020\u0007H\u00d6\u0001R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0014R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017\u00a8\u0006&"}, d2 = {"Lcom/quickbite/app/feature/customer/discovery/DiscoveryUiState;", "", "restaurants", "", "Lcom/quickbite/app/domain/model/Restaurant;", "filteredRestaurants", "categories", "", "selectedCategory", "searchQuery", "isLoading", "", "cartState", "Lcom/quickbite/app/domain/repository/CartState;", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZLcom/quickbite/app/domain/repository/CartState;)V", "getCartState", "()Lcom/quickbite/app/domain/repository/CartState;", "getCategories", "()Ljava/util/List;", "getFilteredRestaurants", "()Z", "getRestaurants", "getSearchQuery", "()Ljava/lang/String;", "getSelectedCategory", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class DiscoveryUiState {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.quickbite.app.domain.model.Restaurant> restaurants = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.quickbite.app.domain.model.Restaurant> filteredRestaurants = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> categories = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String selectedCategory = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String searchQuery = null;
    private final boolean isLoading = false;
    @org.jetbrains.annotations.NotNull()
    private final com.quickbite.app.domain.repository.CartState cartState = null;
    
    public DiscoveryUiState(@org.jetbrains.annotations.NotNull()
    java.util.List<com.quickbite.app.domain.model.Restaurant> restaurants, @org.jetbrains.annotations.NotNull()
    java.util.List<com.quickbite.app.domain.model.Restaurant> filteredRestaurants, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> categories, @org.jetbrains.annotations.NotNull()
    java.lang.String selectedCategory, @org.jetbrains.annotations.NotNull()
    java.lang.String searchQuery, boolean isLoading, @org.jetbrains.annotations.NotNull()
    com.quickbite.app.domain.repository.CartState cartState) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.quickbite.app.domain.model.Restaurant> getRestaurants() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.quickbite.app.domain.model.Restaurant> getFilteredRestaurants() {
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
    public final java.lang.String getSearchQuery() {
        return null;
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.quickbite.app.domain.repository.CartState getCartState() {
        return null;
    }
    
    public DiscoveryUiState() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.quickbite.app.domain.model.Restaurant> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.quickbite.app.domain.model.Restaurant> component2() {
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
    public final java.lang.String component5() {
        return null;
    }
    
    public final boolean component6() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.quickbite.app.domain.repository.CartState component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.quickbite.app.feature.customer.discovery.DiscoveryUiState copy(@org.jetbrains.annotations.NotNull()
    java.util.List<com.quickbite.app.domain.model.Restaurant> restaurants, @org.jetbrains.annotations.NotNull()
    java.util.List<com.quickbite.app.domain.model.Restaurant> filteredRestaurants, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> categories, @org.jetbrains.annotations.NotNull()
    java.lang.String selectedCategory, @org.jetbrains.annotations.NotNull()
    java.lang.String searchQuery, boolean isLoading, @org.jetbrains.annotations.NotNull()
    com.quickbite.app.domain.repository.CartState cartState) {
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