package com.quickbite.app

import com.quickbite.app.core.common.CurrencyUtils
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class CurrencyUtilsTest {

    @Test
    fun testFormatMinorUnitsToINR() {
        // 4900 paise = ₹49
        val formatted49 = CurrencyUtils.formatMinorUnits(4900L)
        assertTrue(formatted49.contains("49"))

        // 38000 paise = ₹380
        val formatted380 = CurrencyUtils.formatMinorUnits(38000L)
        assertTrue(formatted380.contains("380"))
    }

    @Test
    fun testTaxCalculationIsFivePercentRounded() {
        // 5% of 10000 (₹100) = 500 (₹5)
        assertEquals(500L, CurrencyUtils.calculateTaxMinor(10000L))

        // 5% of 38000 (₹380) = 1900 (₹19)
        assertEquals(1900L, CurrencyUtils.calculateTaxMinor(38000L))

        // 5% of 49900 (₹499) = 2495 (₹24.95)
        assertEquals(2495L, CurrencyUtils.calculateTaxMinor(49900L))
    }
}
