package com.quickbite.app.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DeliveryDining
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.quickbite.app.core.design.CoralPrimary
import com.quickbite.app.core.ui.components.DemoRoleSelectorBar
import com.quickbite.app.domain.model.UserRole
import com.quickbite.app.feature.customer.cart.CartScreen
import com.quickbite.app.feature.customer.cart.CartViewModel
import com.quickbite.app.feature.customer.checkout.CheckoutScreen
import com.quickbite.app.feature.customer.checkout.CheckoutViewModel
import com.quickbite.app.feature.customer.details.RestaurantDetailsScreen
import com.quickbite.app.feature.customer.details.RestaurantDetailsViewModel
import com.quickbite.app.feature.customer.discovery.RestaurantDiscoveryScreen
import com.quickbite.app.feature.customer.discovery.RestaurantDiscoveryViewModel
import com.quickbite.app.feature.customer.history.OrderHistoryScreen
import com.quickbite.app.feature.customer.history.OrderHistoryViewModel
import com.quickbite.app.feature.customer.tracking.LiveOrderTrackingScreen
import com.quickbite.app.feature.customer.tracking.OrderTrackingViewModel
import com.quickbite.app.feature.delivery.dashboard.DeliveryDashboardScreen
import com.quickbite.app.feature.delivery.dashboard.DeliveryDashboardViewModel
import com.quickbite.app.feature.profile.ProfileScreen
import com.quickbite.app.feature.profile.ProfileViewModel
import com.quickbite.app.feature.restaurant.dashboard.RestaurantDashboardScreen
import com.quickbite.app.feature.restaurant.dashboard.RestaurantDashboardViewModel

data class BottomNavItem(
    val title: String,
    val route: String,
    val icon: ImageVector
)

@Composable
fun QuickBiteNavHost(
    profileViewModel: ProfileViewModel = hiltViewModel(),
    navController: NavHostController = rememberNavController()
) {
    val currentRole by profileViewModel.currentRole.collectAsStateWithLifecycle()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val bottomNavItems = when (currentRole) {
        UserRole.CUSTOMER -> listOf(
            BottomNavItem("Explore", AppDestination.Discovery.route, Icons.Default.Search),
            BottomNavItem("Orders", AppDestination.OrderHistory.route, Icons.Default.History),
            BottomNavItem("Profile", AppDestination.Profile.route, Icons.Default.Person)
        )
        UserRole.RESTAURANT -> listOf(
            BottomNavItem("Kitchen", AppDestination.RestaurantDashboard.route, Icons.Default.Restaurant),
            BottomNavItem("Profile", AppDestination.Profile.route, Icons.Default.Person)
        )
        UserRole.DELIVERY_PARTNER -> listOf(
            BottomNavItem("Deliveries", AppDestination.DeliveryDashboard.route, Icons.Default.DeliveryDining),
            BottomNavItem("Profile", AppDestination.Profile.route, Icons.Default.Person)
        )
    }

    Scaffold(
        topBar = {
            DemoRoleSelectorBar(
                currentRole = currentRole,
                onRoleSelected = { selectedRole ->
                    profileViewModel.switchRole(selectedRole)
                    when (selectedRole) {
                        UserRole.CUSTOMER -> {
                            navController.navigate(AppDestination.Discovery.route) {
                                popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                                launchSingleTop = true
                            }
                        }
                        UserRole.RESTAURANT -> {
                            navController.navigate(AppDestination.RestaurantDashboard.route) {
                                popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                                launchSingleTop = true
                            }
                        }
                        UserRole.DELIVERY_PARTNER -> {
                            navController.navigate(AppDestination.DeliveryDashboard.route) {
                                popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                                launchSingleTop = true
                            }
                        }
                    }
                }
            )
        },
        bottomBar = {
            val showBottomBar = currentRoute in listOf(
                AppDestination.Discovery.route,
                AppDestination.OrderHistory.route,
                AppDestination.RestaurantDashboard.route,
                AppDestination.DeliveryDashboard.route,
                AppDestination.Profile.route
            )

            if (showBottomBar) {
                NavigationBar(
                    containerColor = MaterialTheme.colorScheme.surface,
                    tonalElevation = 8.dp
                ) {
                    bottomNavItems.forEach { item ->
                        val isSelected = currentRoute == item.route
                        NavigationBarItem(
                            selected = isSelected,
                            onClick = {
                                if (currentRoute != item.route) {
                                    navController.navigate(item.route) {
                                        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                }
                            },
                            icon = { Icon(item.icon, contentDescription = item.title) },
                            label = { Text(item.title) },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = CoralPrimary,
                                selectedTextColor = CoralPrimary,
                                indicatorColor = CoralPrimary.copy(alpha = 0.12f)
                            )
                        )
                    }
                }
            }
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            NavHost(
                navController = navController,
                startDestination = AppDestination.Discovery.route
            ) {
                // Customer Flow
                composable(AppDestination.Discovery.route) {
                    val viewModel: RestaurantDiscoveryViewModel = hiltViewModel()
                    RestaurantDiscoveryScreen(
                        viewModel = viewModel,
                        onRestaurantClick = { restaurantId ->
                            navController.navigate(AppDestination.RestaurantDetails.createRoute(restaurantId))
                        },
                        onViewCartClick = {
                            navController.navigate(AppDestination.Cart.route)
                        }
                    )
                }

                composable(
                    route = AppDestination.RestaurantDetails.route,
                    arguments = listOf(navArgument("restaurantId") { type = NavType.StringType })
                ) {
                    val viewModel: RestaurantDetailsViewModel = hiltViewModel()
                    RestaurantDetailsScreen(
                        viewModel = viewModel,
                        onBackClick = { navController.popBackStack() },
                        onViewCartClick = { navController.navigate(AppDestination.Cart.route) }
                    )
                }

                composable(AppDestination.Cart.route) {
                    val viewModel: CartViewModel = hiltViewModel()
                    CartScreen(
                        viewModel = viewModel,
                        onBackClick = { navController.popBackStack() },
                        onProceedToCheckout = { navController.navigate(AppDestination.Checkout.route) },
                        onBrowseRestaurants = { navController.navigate(AppDestination.Discovery.route) }
                    )
                }

                composable(AppDestination.Checkout.route) {
                    val viewModel: CheckoutViewModel = hiltViewModel()
                    CheckoutScreen(
                        viewModel = viewModel,
                        onBackClick = { navController.popBackStack() },
                        onOrderPlaced = { orderId ->
                            navController.navigate(AppDestination.OrderTracking.createRoute(orderId)) {
                                popUpTo(AppDestination.Discovery.route)
                            }
                        }
                    )
                }

                composable(
                    route = AppDestination.OrderTracking.route,
                    arguments = listOf(navArgument("orderId") { type = NavType.StringType })
                ) {
                    val viewModel: OrderTrackingViewModel = hiltViewModel()
                    LiveOrderTrackingScreen(
                        viewModel = viewModel,
                        onBackClick = {
                            navController.navigate(AppDestination.OrderHistory.route) {
                                popUpTo(AppDestination.Discovery.route)
                            }
                        }
                    )
                }

                composable(AppDestination.OrderHistory.route) {
                    val viewModel: OrderHistoryViewModel = hiltViewModel()
                    OrderHistoryScreen(
                        viewModel = viewModel,
                        onTrackOrderClick = { orderId ->
                            navController.navigate(AppDestination.OrderTracking.createRoute(orderId))
                        }
                    )
                }

                // Restaurant Flow
                composable(AppDestination.RestaurantDashboard.route) {
                    val viewModel: RestaurantDashboardViewModel = hiltViewModel()
                    RestaurantDashboardScreen(viewModel = viewModel)
                }

                // Delivery Partner Flow
                composable(AppDestination.DeliveryDashboard.route) {
                    val viewModel: DeliveryDashboardViewModel = hiltViewModel()
                    DeliveryDashboardScreen(viewModel = viewModel)
                }

                // Profile / Settings Flow
                composable(AppDestination.Profile.route) {
                    ProfileScreen(viewModel = profileViewModel)
                }
            }
        }
    }
}
