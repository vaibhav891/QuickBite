package com.quickbite.app.data.seed

import com.quickbite.app.core.common.Constants
import com.quickbite.app.domain.model.MenuItem
import com.quickbite.app.domain.model.Order
import com.quickbite.app.domain.model.OrderItem
import com.quickbite.app.domain.model.OrderStatus
import com.quickbite.app.domain.model.Restaurant

object SeedData {

    val restaurants: List<Restaurant> = listOf(
        Restaurant(
            id = "rest_01",
            name = "Golden Dragon Asian Bistro",
            description = "Artisanal Dim Sum, hand-pulled Dan Dan noodles, and fragrant wok delicacies.",
            cuisineTypes = listOf("Pan-Asian", "Dim Sum", "Chinese", "Thai"),
            imageUrl = "https://images.unsplash.com/photo-1540420773420-3366772f4999?auto=format&fit=crop&w=800&q=80",
            isOpen = true,
            deliveryFeeMinor = 4900,
            estimatedDeliveryMinutes = 25,
            rating = 4.8,
            ratingCount = 420,
            address = "Unit 12, High Street Food Row, Mumbai",
            latitude = 19.0760,
            longitude = 72.8777
        ),
        Restaurant(
            id = "rest_02",
            name = "Bella Italia Trattoria",
            description = "Wood-fired Neapolitan sourdough pizza, fresh hand-rolled pasta, and creamy tiramisu.",
            cuisineTypes = listOf("Italian", "Wood-fired Pizza", "Pasta"),
            imageUrl = "https://images.unsplash.com/photo-1555396273-367ea4eb4db5?auto=format&fit=crop&w=800&q=80",
            isOpen = true,
            deliveryFeeMinor = 3900,
            estimatedDeliveryMinutes = 30,
            rating = 4.9,
            ratingCount = 580,
            address = "45 Piazza Garden, Bandra West, Mumbai",
            latitude = 19.0600,
            longitude = 72.8350
        ),
        Restaurant(
            id = "rest_03",
            name = "The Prime Smokehouse & Burgers",
            description = "Smashed brioche burgers, slow-smoked Texas brisket, and loaded truffle parmesan fries.",
            cuisineTypes = listOf("Burgers", "American", "BBQ", "Comfort Food"),
            imageUrl = "https://images.unsplash.com/photo-1568901346375-23c9450c58cd?auto=format&fit=crop&w=800&q=80",
            isOpen = true,
            deliveryFeeMinor = 4900,
            estimatedDeliveryMinutes = 20,
            rating = 4.7,
            ratingCount = 310,
            address = "78 Bayview Promenade, Worli, Mumbai",
            latitude = 19.0144,
            longitude = 72.8154
        ),
        Restaurant(
            id = "rest_04",
            name = "Tokyo Sushi Omakase",
            description = "Premium sashimi grade Atlantic salmon, spicy bluefin tuna rolls, and rich tonkotsu ramen.",
            cuisineTypes = listOf("Japanese", "Sushi", "Ramen", "Asian"),
            imageUrl = "https://images.unsplash.com/photo-1579871494447-9811cf80d66c?auto=format&fit=crop&w=800&q=80",
            isOpen = true,
            deliveryFeeMinor = 5900,
            estimatedDeliveryMinutes = 35,
            rating = 4.9,
            ratingCount = 650,
            address = "90 Marina Arcade, Colaba, Mumbai",
            latitude = 18.9220,
            longitude = 72.8346
        ),
        Restaurant(
            id = "rest_05",
            name = "Green Leaf Superfoods",
            description = "Nutrient-packed Mediterranean grain bowls, cold-pressed smoothies, and gluten-free wraps.",
            cuisineTypes = listOf("Healthy", "Salads", "Grain Bowls", "Smoothies"),
            imageUrl = "https://images.unsplash.com/photo-1512621776951-a57141f2eefd?auto=format&fit=crop&w=800&q=80",
            isOpen = true,
            deliveryFeeMinor = 2900,
            estimatedDeliveryMinutes = 25,
            rating = 4.6,
            ratingCount = 195,
            address = "14 Eco Central, Powai, Mumbai",
            latitude = 19.1176,
            longitude = 72.9060
        )
    )

    val menuItems: Map<String, List<MenuItem>> = mapOf(
        "rest_01" to listOf(
            MenuItem(
                id = "item_gd_01",
                restaurantId = "rest_01",
                name = "Steamed Crystal Shrimp Dumplings (Har Gow)",
                description = "Delicate translucent pastry stuffed with plump wild tiger prawns and bamboo shoots.",
                priceMinor = 38000, // ₹380
                imageUrl = "https://images.unsplash.com/photo-1496116218417-1a781b1c416c?auto=format&fit=crop&w=600&q=80",
                category = "Dim Sum",
                isAvailable = true,
                isVegetarian = false,
                calories = 240
            ),
            MenuItem(
                id = "item_gd_02",
                restaurantId = "rest_01",
                name = "Crispy Truffle Edamame Potstickers",
                description = "Pan-seared dumplings filled with sweet edamame puree and white truffle oil drizzle.",
                priceMinor = 34000, // ₹340
                imageUrl = "https://images.unsplash.com/photo-1541696432-82c6da8ce7bf?auto=format&fit=crop&w=600&q=80",
                category = "Dim Sum",
                isAvailable = true,
                isVegetarian = true,
                calories = 210
            ),
            MenuItem(
                id = "item_gd_03",
                restaurantId = "rest_01",
                name = "Sichuan Dan Dan Noodles",
                description = "Fresh wheat noodles tossed in fiery chili oil, sesame paste, minced chicken and crushed peanuts.",
                priceMinor = 42000, // ₹420
                imageUrl = "https://images.unsplash.com/photo-1582878826629-29b7ad1cdc43?auto=format&fit=crop&w=600&q=80",
                category = "Noodles & Wok",
                isAvailable = true,
                isVegetarian = false,
                calories = 520
            ),
            MenuItem(
                id = "item_gd_04",
                restaurantId = "rest_01",
                name = "Kung Pao Tofu & Cashews",
                description = "Wok-tossed golden organic tofu with crunchy cashew nuts, bell peppers, and dried red chilies.",
                priceMinor = 39000, // ₹390
                imageUrl = "https://images.unsplash.com/photo-1525755662778-989d0524087e?auto=format&fit=crop&w=600&q=80",
                category = "Mains",
                isAvailable = true,
                isVegetarian = true,
                calories = 380
            ),
            MenuItem(
                id = "item_gd_05",
                restaurantId = "rest_01",
                name = "Fragrant Thai Green Chicken Curry",
                description = "Creamy coconut milk curry simmered with kaffir lime leaves, sweet basil, bamboo, and jasmine rice.",
                priceMinor = 48000, // ₹480
                imageUrl = "https://images.unsplash.com/photo-1455619452474-d2be8b1e70cd?auto=format&fit=crop&w=600&q=80",
                category = "Mains",
                isAvailable = true,
                isVegetarian = false,
                calories = 610
            ),
            MenuItem(
                id = "item_gd_06",
                restaurantId = "rest_01",
                name = "Steamed Jasmine Rice",
                description = "Fluffy aromatic long-grain jasmine rice.",
                priceMinor = 15000, // ₹150
                imageUrl = "https://images.unsplash.com/photo-1516684732162-798a0062be99?auto=format&fit=crop&w=600&q=80",
                category = "Sides",
                isAvailable = true,
                isVegetarian = true,
                calories = 180
            )
        ),
        "rest_02" to listOf(
            MenuItem(
                id = "item_bi_01",
                restaurantId = "rest_02",
                name = "Margherita D.O.P. Wood-fired Pizza",
                description = "San Marzano tomato sauce, fresh buffalo mozzarella, aromatic sweet basil, extra virgin olive oil.",
                priceMinor = 49000, // ₹490
                imageUrl = "https://images.unsplash.com/photo-1604382355076-af4b0eb60143?auto=format&fit=crop&w=600&q=80",
                category = "Wood-fired Pizza",
                isAvailable = true,
                isVegetarian = true,
                calories = 680
            ),
            MenuItem(
                id = "item_bi_02",
                restaurantId = "rest_02",
                name = "Spicy Diavola Pepperoni Pizza",
                description = "Crispy artisan crust layered with spicy Italian salami, roasted chili flakes, and smoked provolone.",
                priceMinor = 58000, // ₹580
                imageUrl = "https://images.unsplash.com/photo-1628840042765-356cda07504e?auto=format&fit=crop&w=600&q=80",
                category = "Wood-fired Pizza",
                isAvailable = true,
                isVegetarian = false,
                calories = 790
            ),
            MenuItem(
                id = "item_bi_03",
                restaurantId = "rest_02",
                name = "Handcrafted Truffle Tagliolini",
                description = "Freshly extruded egg tagliolini pasta tossed in rich butter emulsion and shaved black summer truffles.",
                priceMinor = 55000, // ₹550
                imageUrl = "https://images.unsplash.com/photo-1551183053-bf91a1d81141?auto=format&fit=crop&w=600&q=80",
                category = "Handmade Pasta",
                isAvailable = true,
                isVegetarian = true,
                calories = 540
            ),
            MenuItem(
                id = "item_bi_04",
                restaurantId = "rest_02",
                name = "Classic Bolognese Rigatoni",
                description = "Slow-simmered 6-hour minced beef and pork ragù with Parmigiano-Reggiano aged 24 months.",
                priceMinor = 52000, // ₹520
                imageUrl = "https://images.unsplash.com/photo-1621996346565-e3d5d628169e?auto=format&fit=crop&w=600&q=80",
                category = "Handmade Pasta",
                isAvailable = true,
                isVegetarian = false,
                calories = 620
            ),
            MenuItem(
                id = "item_bi_05",
                restaurantId = "rest_02",
                name = "Venetian Tiramisu Tradizionale",
                description = "Espresso-soaked savoiardi ladyfingers layered with velvety mascarpone zabaione cream and cocoa.",
                priceMinor = 32000, // ₹320
                imageUrl = "https://images.unsplash.com/photo-1571877227200-a0d98ea607e9?auto=format&fit=crop&w=600&q=80",
                category = "Desserts",
                isAvailable = true,
                isVegetarian = true,
                calories = 360
            )
        ),
        "rest_03" to listOf(
            MenuItem(
                id = "item_bb_01",
                restaurantId = "rest_03",
                name = "The Double Truffle Smash Burger",
                description = "Two seasoned prime smash patties, aged sharp cheddar, caramelized shallots, black truffle aioli on brioche.",
                priceMinor = 46000, // ₹460
                imageUrl = "https://images.unsplash.com/photo-1568901346375-23c9450c58cd?auto=format&fit=crop&w=600&q=80",
                category = "Burgers",
                isAvailable = true,
                isVegetarian = false,
                calories = 780
            ),
            MenuItem(
                id = "item_bb_02",
                restaurantId = "rest_03",
                name = "Nashville Hot Crispy Chicken Burger",
                description = "Golden buttermilk fried chicken thigh tossed in cayenne oil glaze, bread & butter pickles, slaw.",
                priceMinor = 42000, // ₹420
                imageUrl = "https://images.unsplash.com/photo-1625813506062-0aeb1d7a094b?auto=format&fit=crop&w=600&q=80",
                category = "Burgers",
                isAvailable = true,
                isVegetarian = false,
                calories = 690
            ),
            MenuItem(
                id = "item_bb_03",
                restaurantId = "rest_03",
                name = "Truffle Parmesan Hand-cut Fries",
                description = "Crispy Idaho russet fries dusted with grated parmesan, sea salt, chopped rosemary and truffle oil.",
                priceMinor = 22000, // ₹220
                imageUrl = "https://images.unsplash.com/photo-1576107232684-1279f3908594?auto=format&fit=crop&w=600&q=80",
                category = "Sides",
                isAvailable = true,
                isVegetarian = true,
                calories = 340
            ),
            MenuItem(
                id = "item_bb_04",
                restaurantId = "rest_03",
                name = "House Thick Bourbon Vanilla Shake",
                description = "Madagascar vanilla bean ice cream spun with whole malted milk and whipped chantilly cream.",
                priceMinor = 26000, // ₹260
                imageUrl = "https://images.unsplash.com/photo-1572490122747-3968b75cc699?auto=format&fit=crop&w=600&q=80",
                category = "Shakes",
                isAvailable = true,
                isVegetarian = true,
                calories = 450
            )
        ),
        "rest_04" to listOf(
            MenuItem(
                id = "item_ts_01",
                restaurantId = "rest_04",
                name = "Salmon Nigiri & Spicy Tuna Combo",
                description = "4 pcs Norwegian salmon nigiri and 6 pcs spicy yellowfin tuna maki with wasabi and pickled ginger.",
                priceMinor = 65000, // ₹650
                imageUrl = "https://images.unsplash.com/photo-1579871494447-9811cf80d66c?auto=format&fit=crop&w=600&q=80",
                category = "Sushi & Sashimi",
                isAvailable = true,
                isVegetarian = false,
                calories = 420
            ),
            MenuItem(
                id = "item_ts_02",
                restaurantId = "rest_04",
                name = "Rich Tonkotsu Chashu Ramen",
                description = "16-hour simmered pork bone broth with springy noodles, braised pork belly, nitamago egg and nori.",
                priceMinor = 54000, // ₹540
                imageUrl = "https://images.unsplash.com/photo-1569718212165-3a8278d5f624?auto=format&fit=crop&w=600&q=80",
                category = "Ramen",
                isAvailable = true,
                isVegetarian = false,
                calories = 620
            ),
            MenuItem(
                id = "item_ts_03",
                restaurantId = "rest_04",
                name = "Steamed Sea Salt Edamame",
                description = "Organic young soybeans steamed with coarse Maldon flaky sea salt.",
                priceMinor = 21000, // ₹210
                imageUrl = "https://images.unsplash.com/photo-1546069901-ba9599a7e63c?auto=format&fit=crop&w=600&q=80",
                category = "Appetizers",
                isAvailable = true,
                isVegetarian = true,
                calories = 140
            )
        ),
        "rest_05" to listOf(
            MenuItem(
                id = "item_gl_01",
                restaurantId = "rest_05",
                name = "Mediterranean Quinoa Power Bowl",
                description = "Herbed tri-color quinoa, Persian cucumbers, Kalamata olives, cherry tomatoes, creamy tahini dressing.",
                priceMinor = 39000, // ₹390
                imageUrl = "https://images.unsplash.com/photo-1512621776951-a57141f2eefd?auto=format&fit=crop&w=600&q=80",
                category = "Superfood Bowls",
                isAvailable = true,
                isVegetarian = true,
                calories = 380
            ),
            MenuItem(
                id = "item_gl_02",
                restaurantId = "rest_05",
                name = "Wild Berry Açaí Super Antioxidant Bowl",
                description = "Organic Amazonian açaí puree topped with chia seeds, raw cacao nibs, fresh blueberries and banana.",
                priceMinor = 41000, // ₹410
                imageUrl = "https://images.unsplash.com/photo-1590301157890-4810ed352733?auto=format&fit=crop&w=600&q=80",
                category = "Superfood Bowls",
                isAvailable = true,
                isVegetarian = true,
                calories = 310
            ),
            MenuItem(
                id = "item_gl_03",
                restaurantId = "rest_05",
                name = "Cold-Pressed Detox Green Cleanse",
                description = "Freshly pressed English cucumber, green apple, celery, spinach, ginger root and lemon.",
                priceMinor = 22000, // ₹220
                imageUrl = "https://images.unsplash.com/photo-1613478223719-2ab802602423?auto=format&fit=crop&w=600&q=80",
                category = "Cold Pressed Juices",
                isAvailable = true,
                isVegetarian = true,
                calories = 95
            )
        )
    )

    /**
     * Seeded orders representing different stages of the lifecycle
     */
    val initialOrders: List<Order> = listOf(
        Order(
            orderId = "order_active_01",
            orderNumber = "QB-104928",
            customerId = Constants.DEMO_CUSTOMER_ID,
            customerName = Constants.DEMO_CUSTOMER_NAME,
            restaurantId = "rest_01",
            restaurantName = "Golden Dragon Asian Bistro",
            deliveryPartnerId = Constants.DEMO_RIDER_ID,
            deliveryPartnerName = Constants.DEMO_RIDER_NAME,
            items = listOf(
                OrderItem("item_gd_01", "Steamed Crystal Shrimp Dumplings (Har Gow)", 2, 38000, 76000),
                OrderItem("item_gd_03", "Sichuan Dan Dan Noodles", 1, 42000, 42000)
            ),
            deliveryAddress = Constants.DEMO_DELIVERY_ADDRESS,
            subtotalMinor = 118000,
            deliveryFeeMinor = 4900,
            taxMinor = 5900,
            totalMinor = 128800,
            status = OrderStatus.PICKED_UP,
            createdAtMs = System.currentTimeMillis() - (15 * 60 * 1000),
            updatedAtMs = System.currentTimeMillis() - (3 * 60 * 1000),
            estimatedDeliveryMinutes = 15
        ),
        Order(
            orderId = "order_incoming_02",
            orderNumber = "QB-948214",
            customerId = "cust_priya_02",
            customerName = "Priya Sharma",
            restaurantId = "rest_01",
            restaurantName = "Golden Dragon Asian Bistro",
            deliveryPartnerId = null,
            items = listOf(
                OrderItem("item_gd_02", "Crispy Truffle Edamame Potstickers", 1, 34000, 34000),
                OrderItem("item_gd_05", "Fragrant Thai Green Chicken Curry", 1, 48000, 48000)
            ),
            deliveryAddress = "Tower B, Lodha Bellissimo, Worli, Mumbai",
            subtotalMinor = 82000,
            deliveryFeeMinor = 4900,
            taxMinor = 4100,
            totalMinor = 91000,
            status = OrderStatus.PLACED,
            createdAtMs = System.currentTimeMillis() - (2 * 60 * 1000),
            updatedAtMs = System.currentTimeMillis() - (2 * 60 * 1000),
            estimatedDeliveryMinutes = 30
        ),
        Order(
            orderId = "order_ready_03",
            orderNumber = "QB-582910",
            customerId = "cust_rohit_03",
            customerName = "Rohit Verma",
            restaurantId = "rest_01",
            restaurantName = "Golden Dragon Asian Bistro",
            deliveryPartnerId = null,
            items = listOf(
                OrderItem("item_gd_04", "Kung Pao Tofu & Cashews", 1, 39000, 39000),
                OrderItem("item_gd_06", "Steamed Jasmine Rice", 2, 15000, 30000)
            ),
            deliveryAddress = "Penthouse 18, Sea View Enclave, Bandra, Mumbai",
            subtotalMinor = 69000,
            deliveryFeeMinor = 4900,
            taxMinor = 3450,
            totalMinor = 77350,
            status = OrderStatus.READY_FOR_PICKUP,
            createdAtMs = System.currentTimeMillis() - (20 * 60 * 1000),
            updatedAtMs = System.currentTimeMillis() - (1 * 60 * 1000),
            estimatedDeliveryMinutes = 20
        )
    )
}
