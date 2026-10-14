package com.quickbite.app.core.common

import java.text.NumberFormat
import java.util.Locale

object CurrencyUtils {
    /**
     * Formats integer minor units (paise) to INR currency string.
     * Example: 49900 -> ₹499.00 or ₹499
     */
    fun formatMinorUnits(minorUnits: Long, showDecimals: Boolean = false): String {
        val amount = minorUnits / 100.0
        val format = NumberFormat.getCurrencyInstance(Locale("en", "IN"))
        if (!showDecimals && minorUnits % 100 == 0L) {
            format.maximumFractionDigits = 0
        } else {
            format.maximumFractionDigits = 2
            format.minimumFractionDigits = 2
        }
        return format.format(amount)
    }

    /**
     * Calculates 5% GST tax on subtotal in minor units
     */
    fun calculateTaxMinor(subtotalMinor: Long): Long {
        return Math.round(subtotalMinor * 0.05)
    }
}
