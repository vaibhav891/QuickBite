package com.quickbite.app.domain.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00000\fJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0000J\u0006\u0010\u0010\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018\u00a8\u0006\u0019"}, d2 = {"Lcom/quickbite/app/domain/model/OrderStatus;", "", "displayName", "", "stepOrder", "", "(Ljava/lang/String;ILjava/lang/String;I)V", "getDisplayName", "()Ljava/lang/String;", "getStepOrder", "()I", "allowedNextStatuses", "", "canTransitionTo", "", "next", "isTerminal", "PLACED", "ACCEPTED", "PREPARING", "READY_FOR_PICKUP", "PICKED_UP", "DELIVERED", "REJECTED", "CANCELLED", "app_debug"})
public enum OrderStatus {
    /*public static final*/ PLACED /* = new PLACED(null, 0) */,
    /*public static final*/ ACCEPTED /* = new ACCEPTED(null, 0) */,
    /*public static final*/ PREPARING /* = new PREPARING(null, 0) */,
    /*public static final*/ READY_FOR_PICKUP /* = new READY_FOR_PICKUP(null, 0) */,
    /*public static final*/ PICKED_UP /* = new PICKED_UP(null, 0) */,
    /*public static final*/ DELIVERED /* = new DELIVERED(null, 0) */,
    /*public static final*/ REJECTED /* = new REJECTED(null, 0) */,
    /*public static final*/ CANCELLED /* = new CANCELLED(null, 0) */;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String displayName = null;
    private final int stepOrder = 0;
    
    OrderStatus(java.lang.String displayName, int stepOrder) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDisplayName() {
        return null;
    }
    
    public final int getStepOrder() {
        return 0;
    }
    
    public final boolean isTerminal() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.quickbite.app.domain.model.OrderStatus> allowedNextStatuses() {
        return null;
    }
    
    public final boolean canTransitionTo(@org.jetbrains.annotations.NotNull()
    com.quickbite.app.domain.model.OrderStatus next) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<com.quickbite.app.domain.model.OrderStatus> getEntries() {
        return null;
    }
}