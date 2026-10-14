package com.quickbite.app.data.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00132\u0006\u0010\u0014\u001a\u00020\u000eH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00182\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016J$\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00132\u0006\u0010\u0014\u001a\u00020\u000eH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001e\u0010\u0016J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010 \u001a\u00020\u001dH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\nR \u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006!"}, d2 = {"Lcom/quickbite/app/data/repository/DeliveryRepositoryImpl;", "Lcom/quickbite/app/domain/repository/DeliveryRepository;", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "simulationEngine", "Lcom/quickbite/app/core/location/SimulatedLocationEngine;", "(Lcom/google/firebase/firestore/FirebaseFirestore;Lcom/quickbite/app/core/location/SimulatedLocationEngine;)V", "isSimulating", "Lkotlinx/coroutines/flow/StateFlow;", "", "()Lkotlinx/coroutines/flow/StateFlow;", "localDeliveries", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "", "Lcom/quickbite/app/domain/model/Delivery;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "advanceSimulationStep", "Lkotlin/Result;", "orderId", "advanceSimulationStep-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDelivery", "Lkotlinx/coroutines/flow/Flow;", "getRouteWaypoints", "", "Lcom/quickbite/app/core/location/Coordinates;", "markDelivered", "", "markDelivered-gIAlu-s", "startAutoSimulation", "stopAutoSimulation", "app_release"})
public final class DeliveryRepositoryImpl implements com.quickbite.app.domain.repository.DeliveryRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.FirebaseFirestore firestore = null;
    @org.jetbrains.annotations.NotNull()
    private final com.quickbite.app.core.location.SimulatedLocationEngine simulationEngine = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isSimulating = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.Map<java.lang.String, com.quickbite.app.domain.model.Delivery>> localDeliveries = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope scope = null;
    
    @javax.inject.Inject()
    public DeliveryRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.google.firebase.firestore.FirebaseFirestore firestore, @org.jetbrains.annotations.NotNull()
    com.quickbite.app.core.location.SimulatedLocationEngine simulationEngine) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isSimulating() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<com.quickbite.app.domain.model.Delivery> getDelivery(@org.jetbrains.annotations.NotNull()
    java.lang.String orderId) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.List<com.quickbite.app.core.location.Coordinates> getRouteWaypoints() {
        return null;
    }
    
    @java.lang.Override()
    public void startAutoSimulation(@org.jetbrains.annotations.NotNull()
    java.lang.String orderId) {
    }
    
    @java.lang.Override()
    public void stopAutoSimulation() {
    }
}