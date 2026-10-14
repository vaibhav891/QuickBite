package com.quickbite.app.core.notifications

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class QuickBiteMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

        val title = remoteMessage.notification?.title 
            ?: remoteMessage.data["title"] 
            ?: "QuickBite Order Update"
        val body = remoteMessage.notification?.body 
            ?: remoteMessage.data["body"] 
            ?: "Your order status has changed."
        val orderId = remoteMessage.data["orderId"] ?: "demo_order"

        NotificationHelper.showOrderNotification(
            context = applicationContext,
            orderId = orderId,
            title = title,
            message = body
        )
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        // Store or register new FCM token with backend/Firestore user profile
    }
}
