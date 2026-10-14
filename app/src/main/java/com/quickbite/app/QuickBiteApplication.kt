package com.quickbite.app

import android.app.Application
import com.google.firebase.FirebaseApp
import com.stripe.android.PaymentConfiguration
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class QuickBiteApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        // Initialize Firebase
        try {
            FirebaseApp.initializeApp(this)
        } catch (e: Exception) {
            // Firebase initialized or config loaded
        }

        // Initialize Stripe with test publishable key (safe demo key)
        try {
            PaymentConfiguration.init(
                applicationContext,
                "pk_test_51MockStripeQuickBiteTestPublishableKeyPortfolioDemo001"
            )
        } catch (e: Exception) {
            // Fallback for demo environments
        }
    }
}
