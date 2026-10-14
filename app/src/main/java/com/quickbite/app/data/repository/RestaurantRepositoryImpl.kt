package com.quickbite.app.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.quickbite.app.data.seed.SeedData
import com.quickbite.app.domain.model.MenuItem
import com.quickbite.app.domain.model.Restaurant
import com.quickbite.app.domain.repository.RestaurantRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RestaurantRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore
) : RestaurantRepository {

    override fun getRestaurants(): Flow<List<Restaurant>> = callbackFlow {
        // Send default SeedData immediately for instant UI render
        trySend(SeedData.restaurants)

        val listener = firestore.collection("restaurants")
            .addSnapshotListener { snapshot, error ->
                if (error != null || snapshot == null || snapshot.isEmpty) {
                    // Fall back to SeedData
                    trySend(SeedData.restaurants)
                    return@addSnapshotListener
                }

                val list = snapshot.documents.mapNotNull { doc ->
                    try {
                        Restaurant(
                            id = doc.id,
                            name = doc.getString("name") ?: "",
                            description = doc.getString("description") ?: "",
                            cuisineTypes = (doc.get("cuisineTypes") as? List<*>)?.map { it.toString() } ?: emptyList(),
                            imageUrl = doc.getString("imageUrl") ?: "",
                            isOpen = doc.getBoolean("isOpen") ?: true,
                            deliveryFeeMinor = doc.getLong("deliveryFeeMinor") ?: 4900L,
                            estimatedDeliveryMinutes = doc.getLong("estimatedDeliveryMinutes")?.toInt() ?: 30,
                            rating = doc.getDouble("rating") ?: 4.8,
                            ratingCount = doc.getLong("ratingCount")?.toInt() ?: 100,
                            address = doc.getString("address") ?: ""
                        )
                    } catch (e: Exception) {
                        null
                    }
                }
                if (list.isNotEmpty()) {
                    trySend(list)
                } else {
                    trySend(SeedData.restaurants)
                }
            }

        awaitClose { listener.remove() }
    }

    override fun getRestaurantById(id: String): Flow<Restaurant?> = flow {
        val seeded = SeedData.restaurants.find { it.id == id }
        emit(seeded)

        try {
            val doc = firestore.collection("restaurants").document(id).get().await()
            if (doc.exists()) {
                val restaurant = Restaurant(
                    id = doc.id,
                    name = doc.getString("name") ?: (seeded?.name ?: ""),
                    description = doc.getString("description") ?: (seeded?.description ?: ""),
                    cuisineTypes = (doc.get("cuisineTypes") as? List<*>)?.map { it.toString() } ?: (seeded?.cuisineTypes ?: emptyList()),
                    imageUrl = doc.getString("imageUrl") ?: (seeded?.imageUrl ?: ""),
                    isOpen = doc.getBoolean("isOpen") ?: true,
                    deliveryFeeMinor = doc.getLong("deliveryFeeMinor") ?: (seeded?.deliveryFeeMinor ?: 4900L),
                    estimatedDeliveryMinutes = doc.getLong("estimatedDeliveryMinutes")?.toInt() ?: 30,
                    rating = doc.getDouble("rating") ?: 4.8,
                    ratingCount = doc.getLong("ratingCount")?.toInt() ?: 100
                )
                emit(restaurant)
            }
        } catch (_: Exception) {}
    }

    override fun getMenuItems(restaurantId: String): Flow<List<MenuItem>> = callbackFlow {
        val seeded = SeedData.menuItems[restaurantId] ?: SeedData.menuItems["rest_01"] ?: emptyList()
        trySend(seeded)

        val listener = firestore.collection("restaurants")
            .document(restaurantId)
            .collection("menuItems")
            .addSnapshotListener { snapshot, error ->
                if (error != null || snapshot == null || snapshot.isEmpty) {
                    trySend(seeded)
                    return@addSnapshotListener
                }

                val list = snapshot.documents.mapNotNull { doc ->
                    try {
                        MenuItem(
                            id = doc.id,
                            restaurantId = restaurantId,
                            name = doc.getString("name") ?: "",
                            description = doc.getString("description") ?: "",
                            priceMinor = doc.getLong("priceMinor") ?: 10000L,
                            imageUrl = doc.getString("imageUrl") ?: "",
                            category = doc.getString("category") ?: "Mains",
                            isAvailable = doc.getBoolean("isAvailable") ?: true,
                            isVegetarian = doc.getBoolean("isVegetarian") ?: false,
                            calories = doc.getLong("calories")?.toInt()
                        )
                    } catch (e: Exception) {
                        null
                    }
                }
                if (list.isNotEmpty()) {
                    trySend(list)
                } else {
                    trySend(seeded)
                }
            }

        awaitClose { listener.remove() }
    }

    override fun getCuisineCategories(): List<String> {
        return listOf("All", "Pan-Asian", "Italian", "Burgers", "Japanese", "Healthy", "Dim Sum")
    }

    override suspend fun seedFirestoreIfEmpty(): Result<Unit> {
        return try {
            val existing = firestore.collection("restaurants").limit(1).get().await()
            if (!existing.isEmpty) {
                return Result.success(Unit)
            }

            for (rest in SeedData.restaurants) {
                val restDoc = firestore.collection("restaurants").document(rest.id)
                restDoc.set(
                    mapOf(
                        "name" to rest.name,
                        "description" to rest.description,
                        "cuisineTypes" to rest.cuisineTypes,
                        "imageUrl" to rest.imageUrl,
                        "isOpen" to rest.isOpen,
                        "deliveryFeeMinor" to rest.deliveryFeeMinor,
                        "estimatedDeliveryMinutes" to rest.estimatedDeliveryMinutes,
                        "rating" to rest.rating,
                        "ratingCount" to rest.ratingCount,
                        "address" to rest.address
                    )
                ).await()

                val items = SeedData.menuItems[rest.id] ?: emptyList()
                for (item in items) {
                    restDoc.collection("menuItems").document(item.id).set(
                        mapOf(
                            "name" to item.name,
                            "description" to item.description,
                            "priceMinor" to item.priceMinor,
                            "imageUrl" to item.imageUrl,
                            "category" to item.category,
                            "isAvailable" to item.isAvailable,
                            "isVegetarian" to item.isVegetarian,
                            "calories" to item.calories
                        )
                    ).await()
                }
            }
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
