package com.quickbite.app.domain.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J$\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000e2\u0006\u0010\t\u001a\u00020\nH&J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H&J$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00072\u0006\u0010\t\u001a\u00020\nH\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0014\u0010\fJ\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u0016\u001a\u00020\u0013H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u0017"}, d2 = {"Lcom/quickbite/app/domain/repository/DeliveryRepository;", "", "isSimulating", "Lkotlinx/coroutines/flow/StateFlow;", "", "()Lkotlinx/coroutines/flow/StateFlow;", "advanceSimulationStep", "Lkotlin/Result;", "Lcom/quickbite/app/domain/model/Delivery;", "orderId", "", "advanceSimulationStep-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDelivery", "Lkotlinx/coroutines/flow/Flow;", "getRouteWaypoints", "", "Lcom/quickbite/app/core/location/Coordinates;", "markDelivered", "", "markDelivered-gIAlu-s", "startAutoSimulation", "stopAutoSimulation", "app_release"})
public abstract interface DeliveryRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isSimulating();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.quickbite.app.domain.model.Delivery> getDelivery(@org.jetbrains.annotations.NotNull()
    java.lang.String orderId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.quickbite.app.core.location.Coordinates> getRouteWaypoints();
    
    public abstract void startAutoSimulation(@org.jetbrains.annotations.NotNull()
    java.lang.String orderId);
    
    public abstract void stopAutoSimulation();
}