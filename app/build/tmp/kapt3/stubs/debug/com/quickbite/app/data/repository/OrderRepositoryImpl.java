package com.quickbite.app.data.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J4\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013Jb\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\t2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b \u0010!JB\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00160\f2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\t2\u0006\u0010\u001d\u001a\u00020\u000fH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b#\u0010$J\u001c\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0&2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0014\u0010\'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0&H\u0016J\u0018\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0&2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\t0&2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0&2\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\u001c\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0&2\u0006\u0010\u0019\u001a\u00020\u000fH\u0016J\u0012\u0010-\u001a\u0004\u0018\u00010\n2\u0006\u0010.\u001a\u00020/H\u0002JP\u00100\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u000f2\u0006\u00104\u001a\u00020\u000f2\b\u00105\u001a\u0004\u0018\u00010\u000f2\b\u00106\u001a\u0004\u0018\u00010\u000fH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b7\u00108R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u00069"}, d2 = {"Lcom/quickbite/app/data/repository/OrderRepositoryImpl;", "Lcom/quickbite/app/domain/repository/OrderRepository;", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "functions", "Lcom/google/firebase/functions/FirebaseFunctions;", "(Lcom/google/firebase/firestore/FirebaseFirestore;Lcom/google/firebase/functions/FirebaseFunctions;)V", "localOrders", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/quickbite/app/domain/model/Order;", "claimDelivery", "Lkotlin/Result;", "", "orderId", "", "deliveryPartnerId", "deliveryPartnerName", "claimDelivery-BWLJW6A", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmAndPlaceOrder", "draft", "Lcom/quickbite/app/domain/repository/PaymentDraftResult;", "customerId", "customerName", "restaurantId", "restaurantName", "items", "Lcom/quickbite/app/domain/model/CartItem;", "deliveryAddress", "isMockPayment", "", "confirmAndPlaceOrder-tZkwj4A", "(Lcom/quickbite/app/domain/repository/PaymentDraftResult;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createCheckoutDraft", "createCheckoutDraft-yxL6bBk", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAssignedDeliveries", "Lkotlinx/coroutines/flow/Flow;", "getAvailableDeliveries", "getOrderById", "getOrderEvents", "Lcom/quickbite/app/domain/model/OrderEvent;", "getOrdersForCustomer", "getOrdersForRestaurant", "parseOrder", "doc", "Lcom/google/firebase/firestore/DocumentSnapshot;", "updateOrderStatus", "newStatus", "Lcom/quickbite/app/domain/model/OrderStatus;", "actorId", "actorRole", "note", "rejectReason", "updateOrderStatus-bMdYcbs", "(Ljava/lang/String;Lcom/quickbite/app/domain/model/OrderStatus;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class OrderRepositoryImpl implements com.quickbite.app.domain.repository.OrderRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.FirebaseFirestore firestore = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.functions.FirebaseFunctions functions = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.quickbite.app.domain.model.Order>> localOrders = null;
    
    @javax.inject.Inject()
    public OrderRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.google.firebase.firestore.FirebaseFirestore firestore, @org.jetbrains.annotations.NotNull()
    com.google.firebase.functions.FirebaseFunctions functions) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.quickbite.app.domain.model.Order>> getOrdersForCustomer(@org.jetbrains.annotations.NotNull()
    java.lang.String customerId) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.quickbite.app.domain.model.Order>> getOrdersForRestaurant(@org.jetbrains.annotations.NotNull()
    java.lang.String restaurantId) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.quickbite.app.domain.model.Order>> getAvailableDeliveries() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.quickbite.app.domain.model.Order>> getAssignedDeliveries(@org.jetbrains.annotations.NotNull()
    java.lang.String deliveryPartnerId) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<com.quickbite.app.domain.model.Order> getOrderById(@org.jetbrains.annotations.NotNull()
    java.lang.String orderId) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.quickbite.app.domain.model.OrderEvent>> getOrderEvents(@org.jetbrains.annotations.NotNull()
    java.lang.String orderId) {
        return null;
    }
    
    private final com.quickbite.app.domain.model.Order parseOrder(com.google.firebase.firestore.DocumentSnapshot doc) {
        return null;
    }
}