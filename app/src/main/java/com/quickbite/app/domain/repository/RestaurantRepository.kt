package com.quickbite.app.domain.repository

import com.quickbite.app.domain.model.MenuItem
import com.quickbite.app.domain.model.Restaurant
import kotlinx.coroutines.flow.Flow

interface RestaurantRepository {
    fun getRestaurants(): Flow<List<Restaurant>>
    fun getRestaurantById(id: String): Flow<Restaurant?>
    fun getMenuItems(restaurantId: String): Flow<List<MenuItem>>
    fun getCuisineCategories(): List<String>
    suspend fun seedFirestoreIfEmpty(): Result<Unit>
}
