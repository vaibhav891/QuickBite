package com.quickbite.app.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\tH\'J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\fH\'J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u000fH\'J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0012H\'\u00a8\u0006\u0013"}, d2 = {"Lcom/quickbite/app/di/RepositoryModule;", "", "()V", "bindAuthRepository", "Lcom/quickbite/app/domain/repository/AuthRepository;", "impl", "Lcom/quickbite/app/data/repository/AuthRepositoryImpl;", "bindCartRepository", "Lcom/quickbite/app/domain/repository/CartRepository;", "Lcom/quickbite/app/data/repository/CartRepositoryImpl;", "bindDeliveryRepository", "Lcom/quickbite/app/domain/repository/DeliveryRepository;", "Lcom/quickbite/app/data/repository/DeliveryRepositoryImpl;", "bindOrderRepository", "Lcom/quickbite/app/domain/repository/OrderRepository;", "Lcom/quickbite/app/data/repository/OrderRepositoryImpl;", "bindRestaurantRepository", "Lcom/quickbite/app/domain/repository/RestaurantRepository;", "Lcom/quickbite/app/data/repository/RestaurantRepositoryImpl;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public abstract class RepositoryModule {
    
    public RepositoryModule() {
        super();
    }
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.quickbite.app.domain.repository.AuthRepository bindAuthRepository(@org.jetbrains.annotations.NotNull()
    com.quickbite.app.data.repository.AuthRepositoryImpl impl);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.quickbite.app.domain.repository.RestaurantRepository bindRestaurantRepository(@org.jetbrains.annotations.NotNull()
    com.quickbite.app.data.repository.RestaurantRepositoryImpl impl);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.quickbite.app.domain.repository.CartRepository bindCartRepository(@org.jetbrains.annotations.NotNull()
    com.quickbite.app.data.repository.CartRepositoryImpl impl);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.quickbite.app.domain.repository.OrderRepository bindOrderRepository(@org.jetbrains.annotations.NotNull()
    com.quickbite.app.data.repository.OrderRepositoryImpl impl);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.quickbite.app.domain.repository.DeliveryRepository bindDeliveryRepository(@org.jetbrains.annotations.NotNull()
    com.quickbite.app.data.repository.DeliveryRepositoryImpl impl);
}