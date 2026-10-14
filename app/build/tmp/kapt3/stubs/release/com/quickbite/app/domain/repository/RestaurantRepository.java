package com.quickbite.app.domain.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u001c\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00030\u00062\u0006\u0010\b\u001a\u00020\u0004H&J\u0018\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00062\u0006\u0010\u000b\u001a\u00020\u0004H&J\u0014\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00030\u0006H&J\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u0012"}, d2 = {"Lcom/quickbite/app/domain/repository/RestaurantRepository;", "", "getCuisineCategories", "", "", "getMenuItems", "Lkotlinx/coroutines/flow/Flow;", "Lcom/quickbite/app/domain/model/MenuItem;", "restaurantId", "getRestaurantById", "Lcom/quickbite/app/domain/model/Restaurant;", "id", "getRestaurants", "seedFirestoreIfEmpty", "Lkotlin/Result;", "", "seedFirestoreIfEmpty-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public abstract interface RestaurantRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.quickbite.app.domain.model.Restaurant>> getRestaurants();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.quickbite.app.domain.model.Restaurant> getRestaurantById(@org.jetbrains.annotations.NotNull()
    java.lang.String id);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.quickbite.app.domain.model.MenuItem>> getMenuItems(@org.jetbrains.annotations.NotNull()
    java.lang.String restaurantId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<java.lang.String> getCuisineCategories();
}