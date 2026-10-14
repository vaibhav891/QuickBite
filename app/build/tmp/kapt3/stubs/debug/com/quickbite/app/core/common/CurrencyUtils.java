package com.quickbite.app.core.common;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\n\u00a8\u0006\u000b"}, d2 = {"Lcom/quickbite/app/core/common/CurrencyUtils;", "", "()V", "calculateTaxMinor", "", "subtotalMinor", "formatMinorUnits", "", "minorUnits", "showDecimals", "", "app_debug"})
public final class CurrencyUtils {
    @org.jetbrains.annotations.NotNull()
    public static final com.quickbite.app.core.common.CurrencyUtils INSTANCE = null;
    
    private CurrencyUtils() {
        super();
    }
    
    /**
     * Formats integer minor units (paise) to INR currency string.
     * Example: 49900 -> ₹499.00 or ₹499
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String formatMinorUnits(long minorUnits, boolean showDecimals) {
        return null;
    }
    
    /**
     * Calculates 5% GST tax on subtotal in minor units
     */
    public final long calculateTaxMinor(long subtotalMinor) {
        return 0L;
    }
}