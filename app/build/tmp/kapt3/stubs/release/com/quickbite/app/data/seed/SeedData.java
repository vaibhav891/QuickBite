package com.quickbite.app.data.seed;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R#\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00040\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/quickbite/app/data/seed/SeedData;", "", "()V", "initialOrders", "", "Lcom/quickbite/app/domain/model/Order;", "getInitialOrders", "()Ljava/util/List;", "menuItems", "", "", "Lcom/quickbite/app/domain/model/MenuItem;", "getMenuItems", "()Ljava/util/Map;", "restaurants", "Lcom/quickbite/app/domain/model/Restaurant;", "getRestaurants", "app_release"})
public final class SeedData {
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<com.quickbite.app.domain.model.Restaurant> restaurants = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.Map<java.lang.String, java.util.List<com.quickbite.app.domain.model.MenuItem>> menuItems = null;
    
    /**
     * Seeded orders representing different stages of the lifecycle
     */
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<com.quickbite.app.domain.model.Order> initialOrders = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.quickbite.app.data.seed.SeedData INSTANCE = null;
    
    private SeedData() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.quickbite.app.domain.model.Restaurant> getRestaurants() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.util.List<com.quickbite.app.domain.model.MenuItem>> getMenuItems() {
        return null;
    }
    
    /**
     * Seeded orders representing different stages of the lifecycle
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.quickbite.app.domain.model.Order> getInitialOrders() {
        return null;
    }
}