package com.quickbite.app.feature.customer.checkout;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BQ\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\t\u0010 \u001a\u00020\u000bH\u00c6\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\rH\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003JU\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010$\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010&\u001a\u00020\'H\u00d6\u0001J\t\u0010(\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0017R\u0013\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006)"}, d2 = {"Lcom/quickbite/app/feature/customer/checkout/CheckoutUiState;", "", "cartState", "Lcom/quickbite/app/domain/repository/CartState;", "deliveryAddress", "", "selectedPaymentOption", "Lcom/quickbite/app/feature/customer/checkout/PaymentOption;", "draft", "Lcom/quickbite/app/domain/repository/PaymentDraftResult;", "isLoading", "", "orderPlaced", "Lcom/quickbite/app/domain/model/Order;", "errorMessage", "(Lcom/quickbite/app/domain/repository/CartState;Ljava/lang/String;Lcom/quickbite/app/feature/customer/checkout/PaymentOption;Lcom/quickbite/app/domain/repository/PaymentDraftResult;ZLcom/quickbite/app/domain/model/Order;Ljava/lang/String;)V", "getCartState", "()Lcom/quickbite/app/domain/repository/CartState;", "getDeliveryAddress", "()Ljava/lang/String;", "getDraft", "()Lcom/quickbite/app/domain/repository/PaymentDraftResult;", "getErrorMessage", "()Z", "getOrderPlaced", "()Lcom/quickbite/app/domain/model/Order;", "getSelectedPaymentOption", "()Lcom/quickbite/app/feature/customer/checkout/PaymentOption;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class CheckoutUiState {
    @org.jetbrains.annotations.NotNull()
    private final com.quickbite.app.domain.repository.CartState cartState = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String deliveryAddress = null;
    @org.jetbrains.annotations.NotNull()
    private final com.quickbite.app.feature.customer.checkout.PaymentOption selectedPaymentOption = null;
    @org.jetbrains.annotations.Nullable()
    private final com.quickbite.app.domain.repository.PaymentDraftResult draft = null;
    private final boolean isLoading = false;
    @org.jetbrains.annotations.Nullable()
    private final com.quickbite.app.domain.model.Order orderPlaced = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String errorMessage = null;
    
    public CheckoutUiState(@org.jetbrains.annotations.NotNull()
    com.quickbite.app.domain.repository.CartState cartState, @org.jetbrains.annotations.NotNull()
    java.lang.String deliveryAddress, @org.jetbrains.annotations.NotNull()
    com.quickbite.app.feature.customer.checkout.PaymentOption selectedPaymentOption, @org.jetbrains.annotations.Nullable()
    com.quickbite.app.domain.repository.PaymentDraftResult draft, boolean isLoading, @org.jetbrains.annotations.Nullable()
    com.quickbite.app.domain.model.Order orderPlaced, @org.jetbrains.annotations.Nullable()
    java.lang.String errorMessage) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.quickbite.app.domain.repository.CartState getCartState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDeliveryAddress() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.quickbite.app.feature.customer.checkout.PaymentOption getSelectedPaymentOption() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.quickbite.app.domain.repository.PaymentDraftResult getDraft() {
        return null;
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.quickbite.app.domain.model.Order getOrderPlaced() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getErrorMessage() {
        return null;
    }
    
    public CheckoutUiState() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.quickbite.app.domain.repository.CartState component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.quickbite.app.feature.customer.checkout.PaymentOption component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.quickbite.app.domain.repository.PaymentDraftResult component4() {
        return null;
    }
    
    public final boolean component5() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.quickbite.app.domain.model.Order component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.quickbite.app.feature.customer.checkout.CheckoutUiState copy(@org.jetbrains.annotations.NotNull()
    com.quickbite.app.domain.repository.CartState cartState, @org.jetbrains.annotations.NotNull()
    java.lang.String deliveryAddress, @org.jetbrains.annotations.NotNull()
    com.quickbite.app.feature.customer.checkout.PaymentOption selectedPaymentOption, @org.jetbrains.annotations.Nullable()
    com.quickbite.app.domain.repository.PaymentDraftResult draft, boolean isLoading, @org.jetbrains.annotations.Nullable()
    com.quickbite.app.domain.model.Order orderPlaced, @org.jetbrains.annotations.Nullable()
    java.lang.String errorMessage) {
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