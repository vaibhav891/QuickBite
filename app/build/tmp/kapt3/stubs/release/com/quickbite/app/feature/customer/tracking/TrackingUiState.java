package com.quickbite.app.feature.customer.tracking;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0002\u0010\fJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\nH\u00c6\u0003J\t\u0010\u0018\u001a\u00020\nH\u00c6\u0003JE\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u000fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006 "}, d2 = {"Lcom/quickbite/app/feature/customer/tracking/TrackingUiState;", "", "order", "Lcom/quickbite/app/domain/model/Order;", "delivery", "Lcom/quickbite/app/domain/model/Delivery;", "waypoints", "", "Lcom/quickbite/app/core/location/Coordinates;", "isAutoSimulating", "", "isLoading", "(Lcom/quickbite/app/domain/model/Order;Lcom/quickbite/app/domain/model/Delivery;Ljava/util/List;ZZ)V", "getDelivery", "()Lcom/quickbite/app/domain/model/Delivery;", "()Z", "getOrder", "()Lcom/quickbite/app/domain/model/Order;", "getWaypoints", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "app_release"})
public final class TrackingUiState {
    @org.jetbrains.annotations.Nullable()
    private final com.quickbite.app.domain.model.Order order = null;
    @org.jetbrains.annotations.Nullable()
    private final com.quickbite.app.domain.model.Delivery delivery = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.quickbite.app.core.location.Coordinates> waypoints = null;
    private final boolean isAutoSimulating = false;
    private final boolean isLoading = false;
    
    public TrackingUiState(@org.jetbrains.annotations.Nullable()
    com.quickbite.app.domain.model.Order order, @org.jetbrains.annotations.Nullable()
    com.quickbite.app.domain.model.Delivery delivery, @org.jetbrains.annotations.NotNull()
    java.util.List<com.quickbite.app.core.location.Coordinates> waypoints, boolean isAutoSimulating, boolean isLoading) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.quickbite.app.domain.model.Order getOrder() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.quickbite.app.domain.model.Delivery getDelivery() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.quickbite.app.core.location.Coordinates> getWaypoints() {
        return null;
    }
    
    public final boolean isAutoSimulating() {
        return false;
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    public TrackingUiState() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.quickbite.app.domain.model.Order component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.quickbite.app.domain.model.Delivery component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.quickbite.app.core.location.Coordinates> component3() {
        return null;
    }
    
    public final boolean component4() {
        return false;
    }
    
    public final boolean component5() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.quickbite.app.feature.customer.tracking.TrackingUiState copy(@org.jetbrains.annotations.Nullable()
    com.quickbite.app.domain.model.Order order, @org.jetbrains.annotations.Nullable()
    com.quickbite.app.domain.model.Delivery delivery, @org.jetbrains.annotations.NotNull()
    java.util.List<com.quickbite.app.core.location.Coordinates> waypoints, boolean isAutoSimulating, boolean isLoading) {
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