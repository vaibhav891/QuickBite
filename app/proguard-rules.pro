# QuickBite Proguard Rules
-keepattributes *Annotation*
-dontwarn javax.annotation.**
-dontwarn org.checkerframework.**

# Firebase & Stripe
-keep class com.stripe.android.** { *; }
-keep class com.google.firebase.** { *; }
