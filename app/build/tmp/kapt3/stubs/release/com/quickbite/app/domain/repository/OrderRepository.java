package com.quickbite.app.domain.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\t\u0010\nJb\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0019\u0010\u001aJB\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001c\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00140\u001f2\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0014\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00140\u001fH&J\u0018\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u001f2\u0006\u0010\u0005\u001a\u00020\u0006H&J\u001c\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00140\u001f2\u0006\u0010\u0005\u001a\u00020\u0006H&J\u001c\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00140\u001f2\u0006\u0010\u000f\u001a\u00020\u0006H&J\u001c\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00140\u001f2\u0006\u0010\u0011\u001a\u00020\u0006H&JT\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00062\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0006H\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b-\u0010.\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006/"}, d2 = {"Lcom/quickbite/app/domain/repository/OrderRepository;", "", "claimDelivery", "Lkotlin/Result;", "", "orderId", "", "deliveryPartnerId", "deliveryPartnerName", "claimDelivery-BWLJW6A", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmAndPlaceOrder", "Lcom/quickbite/app/domain/model/Order;", "draft", "Lcom/quickbite/app/domain/repository/PaymentDraftResult;", "customerId", "customerName", "restaurantId", "restaurantName", "items", "", "Lcom/quickbite/app/domain/model/CartItem;", "deliveryAddress", "isMockPayment", "", "confirmAndPlaceOrder-tZkwj4A", "(Lcom/quickbite/app/domain/repository/PaymentDraftResult;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createCheckoutDraft", "createCheckoutDraft-yxL6bBk", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAssignedDeliveries", "Lkotlinx/coroutines/flow/Flow;", "getAvailableDeliveries", "getOrderById", "getOrderEvents", "Lcom/quickbite/app/domain/model/OrderEvent;", "getOrdersForCustomer", "getOrdersForRestaurant", "updateOrderStatus", "newStatus", "Lcom/quickbite/app/domain/model/OrderStatus;", "actorId", "actorRole", "note", "rejectReason", "updateOrderStatus-bMdYcbs", "(Ljava/lang/String;Lcom/quickbite/app/domain/model/OrderStatus;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public abstract interface OrderRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.quickbite.app.domain.model.Order>> getOrdersForCustomer(@org.jetbrains.annotations.NotNull()
    java.lang.String customerId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.quickbite.app.domain.model.Order>> getOrdersForRestaurant(@org.jetbrains.annotations.NotNull()
    java.lang.String restaurantId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.quickbite.app.domain.model.Order>> getAvailableDeliveries();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.quickbite.app.domain.model.Order>> getAssignedDeliveries(@org.jetbrains.annotations.NotNull()
    java.lang.String deliveryPartnerId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.quickbite.app.domain.model.Order> getOrderById(@org.jetbrains.annotations.NotNull()
    java.lang.String orderId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.quickbite.app.domain.model.OrderEvent>> getOrderEvents(@org.jetbrains.annotations.NotNull()
    java.lang.String orderId);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}