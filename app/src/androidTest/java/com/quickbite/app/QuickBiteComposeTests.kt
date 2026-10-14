package com.quickbite.app

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.quickbite.app.core.design.QuickBiteTheme
import com.quickbite.app.core.ui.components.MenuItemCard
import com.quickbite.app.core.ui.components.OrderStatusTimeline
import com.quickbite.app.core.ui.components.RestaurantCard
import com.quickbite.app.data.seed.SeedData
import com.quickbite.app.domain.model.OrderStatus
import org.junit.Rule
import org.junit.Test

class QuickBiteComposeTests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testRestaurantCardDisplaysDetailsCorrectly() {
        val sampleRestaurant = SeedData.restaurants.first()

        composeTestRule.setContent {
            QuickBiteTheme {
                RestaurantCard(
                    restaurant = sampleRestaurant,
                    onClick = {}
                )
            }
        }

        // Verify restaurant name is displayed
        composeTestRule.onNodeWithText(sampleRestaurant.name).assertIsDisplayed()

        // Verify rating is displayed
        composeTestRule.onNodeWithText("${sampleRestaurant.rating}").assertIsDisplayed()

        // Verify estimated delivery time
        composeTestRule.onNodeWithText("${sampleRestaurant.estimatedDeliveryMinutes} mins").assertIsDisplayed()
    }

    @Test
    fun testMenuItemCardDisplaysDetailsAndAddAction() {
        val sampleItem = SeedData.menuItems["rest_01"]!!.first()
        var added = false

        composeTestRule.setContent {
            QuickBiteTheme {
                MenuItemCard(
                    item = sampleItem,
                    quantityInCart = 0,
                    onAddClick = { added = true },
                    onIncreaseClick = {},
                    onDecreaseClick = {}
                )
            }
        }

        // Verify item name and price
        composeTestRule.onNodeWithText(sampleItem.name).assertIsDisplayed()
        composeTestRule.onNodeWithText(sampleItem.formattedPrice).assertIsDisplayed()

        // Verify ADD button
        composeTestRule.onNodeWithText("ADD").assertIsDisplayed().performClick()
        assert(added)
    }

    @Test
    fun testOrderStatusTimelineDisplaysLifecycleStates() {
        composeTestRule.setContent {
            QuickBiteTheme {
                OrderStatusTimeline(currentStatus = OrderStatus.PREPARING)
            }
        }

        // Verify timeline stages are displayed
        composeTestRule.onNodeWithText("Order Placed").assertIsDisplayed()
        composeTestRule.onNodeWithText("Order Accepted").assertIsDisplayed()
        composeTestRule.onNodeWithText("Preparing Food").assertIsDisplayed()
        composeTestRule.onNodeWithText("Ready for Pickup").assertIsDisplayed()
        composeTestRule.onNodeWithText("Out for Delivery").assertIsDisplayed()
        composeTestRule.onNodeWithText("Delivered").assertIsDisplayed()
    }
}
