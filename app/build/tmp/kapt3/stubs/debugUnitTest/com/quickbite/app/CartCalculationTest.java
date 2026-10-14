package com.quickbite.app;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0007J\b\u0010\u000e\u001a\u00020\rH\u0007J\b\u0010\u000f\u001a\u00020\rH\u0007J\b\u0010\u0010\u001a\u00020\rH\u0007J\b\u0010\u0011\u001a\u00020\rH\u0007J\b\u0010\u0012\u001a\u00020\rH\u0007J\b\u0010\u0013\u001a\u00020\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/quickbite/app/CartCalculationTest;", "", "()V", "cartRepository", "Lcom/quickbite/app/data/repository/CartRepositoryImpl;", "itemDumplings", "Lcom/quickbite/app/domain/model/MenuItem;", "itemNoodles", "itemPizza", "restaurantA", "Lcom/quickbite/app/domain/model/Restaurant;", "restaurantB", "setUp", "", "testAddItemCalculatesSubtotalTaxAndTotalAccurately", "testDecreasingQuantityToZeroRemovesItem", "testEmptyCartInitialState", "testIncreasingQuantityUpdatesTotalsProperly", "testMultipleDistinctItemsCalculation", "testSingleRestaurantRestrictionEnforced", "app_debugUnitTest"})
public final class CartCalculationTest {
    private com.quickbite.app.data.repository.CartRepositoryImpl cartRepository;
    @org.jetbrains.annotations.NotNull()
    private final com.quickbite.app.domain.model.Restaurant restaurantA = null;
    @org.jetbrains.annotations.NotNull()
    private final com.quickbite.app.domain.model.Restaurant restaurantB = null;
    @org.jetbrains.annotations.NotNull()
    private final com.quickbite.app.domain.model.MenuItem itemDumplings = null;
    @org.jetbrains.annotations.NotNull()
    private final com.quickbite.app.domain.model.MenuItem itemNoodles = null;
    @org.jetbrains.annotations.NotNull()
    private final com.quickbite.app.domain.model.MenuItem itemPizza = null;
    
    public CartCalculationTest() {
        super();
    }
    
    @org.junit.Before()
    public final void setUp() {
    }
    
    @org.junit.Test()
    public final void testEmptyCartInitialState() {
    }
    
    @org.junit.Test()
    public final void testAddItemCalculatesSubtotalTaxAndTotalAccurately() {
    }
    
    @org.junit.Test()
    public final void testIncreasingQuantityUpdatesTotalsProperly() {
    }
    
    @org.junit.Test()
    public final void testMultipleDistinctItemsCalculation() {
    }
    
    @org.junit.Test()
    public final void testSingleRestaurantRestrictionEnforced() {
    }
    
    @org.junit.Test()
    public final void testDecreasingQuantityToZeroRemovesItem() {
    }
}