package com.quickbite.app.navigation

sealed class AppDestination(val route: String) {
    data object Discovery : AppDestination("discovery")
    data object RestaurantDetails : AppDestination("restaurant/{restaurantId}") {
        fun createRoute(restaurantId: String) = "restaurant/$restaurantId"
    }
    data object Cart : AppDestination("cart")
    data object Checkout : AppDestination("checkout")
    data object OrderTracking : AppDestination("order_tracking/{orderId}") {
        fun createRoute(orderId: String) = "order_tracking/$orderId"
    }
    data object OrderHistory : AppDestination("order_history")
    data object RestaurantDashboard : AppDestination("restaurant_dashboard")
    data object DeliveryDashboard : AppDestination("delivery_dashboard")
    data object Profile : AppDestination("profile")
}
