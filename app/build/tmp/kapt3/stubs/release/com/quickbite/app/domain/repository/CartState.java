package com.quickbite.app.domain.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0002\u0010\fJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\bH\u00c6\u0003J\t\u0010 \u001a\u00020\bH\u00c6\u0003J\t\u0010!\u001a\u00020\bH\u00c6\u0003J\t\u0010\"\u001a\u00020\bH\u00c6\u0003JM\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bH\u00c6\u0001J\u0013\u0010$\u001a\u00020\u00102\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010&\u001a\u00020\u0019H\u00d6\u0001J\t\u0010\'\u001a\u00020(H\u00d6\u0001R\u0011\u0010\t\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0011\u0010\n\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000eR\u0011\u0010\u0018\u001a\u00020\u00198F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000e\u00a8\u0006)"}, d2 = {"Lcom/quickbite/app/domain/repository/CartState;", "", "restaurant", "Lcom/quickbite/app/domain/model/Restaurant;", "items", "", "Lcom/quickbite/app/domain/model/CartItem;", "subtotalMinor", "", "deliveryFeeMinor", "taxMinor", "totalMinor", "(Lcom/quickbite/app/domain/model/Restaurant;Ljava/util/List;JJJJ)V", "getDeliveryFeeMinor", "()J", "isEmpty", "", "()Z", "getItems", "()Ljava/util/List;", "getRestaurant", "()Lcom/quickbite/app/domain/model/Restaurant;", "getSubtotalMinor", "getTaxMinor", "totalItemCount", "", "getTotalItemCount", "()I", "getTotalMinor", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "app_release"})
public final class CartState {
    @org.jetbrains.annotations.Nullable()
    private final com.quickbite.app.domain.model.Restaurant restaurant = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.quickbite.app.domain.model.CartItem> items = null;
    private final long subtotalMinor = 0L;
    private final long deliveryFeeMinor = 0L;
    private final long taxMinor = 0L;
    private final long totalMinor = 0L;
    
    public CartState(@org.jetbrains.annotations.Nullable()
    com.quickbite.app.domain.model.Restaurant restaurant, @org.jetbrains.annotations.NotNull()
    java.util.List<com.quickbite.app.domain.model.CartItem> items, long subtotalMinor, long deliveryFeeMinor, long taxMinor, long totalMinor) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.quickbite.app.domain.model.Restaurant getRestaurant() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.quickbite.app.domain.model.CartItem> getItems() {
        return null;
    }
    
    public final long getSubtotalMinor() {
        return 0L;
    }
    
    public final long getDeliveryFeeMinor() {
        return 0L;
    }
    
    public final long getTaxMinor() {
        return 0L;
    }
    
    public final long getTotalMinor() {
        return 0L;
    }
    
    public final int getTotalItemCount() {
        return 0;
    }
    
    public final boolean isEmpty() {
        return false;
    }
    
    public CartState() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.quickbite.app.domain.model.Restaurant component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.quickbite.app.domain.model.CartItem> component2() {
        return null;
    }
    
    public final long component3() {
        return 0L;
    }
    
    public final long component4() {
        return 0L;
    }
    
    public final long component5() {
        return 0L;
    }
    
    public final long component6() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.quickbite.app.domain.repository.CartState copy(@org.jetbrains.annotations.Nullable()
    com.quickbite.app.domain.model.Restaurant restaurant, @org.jetbrains.annotations.NotNull()
    java.util.List<com.quickbite.app.domain.model.CartItem> items, long subtotalMinor, long deliveryFeeMinor, long taxMinor, long totalMinor) {
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