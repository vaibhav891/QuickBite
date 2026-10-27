package com.quickbite.app.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.functions.FirebaseFunctions
import com.quickbite.app.core.location.SimulatedLocationEngine
import com.quickbite.app.data.repository.AuthRepositoryImpl
import com.quickbite.app.data.repository.CartRepositoryImpl
import com.quickbite.app.data.repository.DeliveryRepositoryImpl
import com.quickbite.app.data.repository.OrderRepositoryImpl
import com.quickbite.app.data.repository.RestaurantRepositoryImpl
import com.quickbite.app.domain.repository.AuthRepository
import com.quickbite.app.domain.repository.CartRepository
import com.quickbite.app.domain.repository.DeliveryRepository
import com.quickbite.app.domain.repository.OrderRepository
import com.quickbite.app.domain.repository.RestaurantRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAuthRepository(impl: AuthRepositoryImpl): AuthRepository

    @Binds
    @Singleton
    abstract fun bindRestaurantRepository(impl: RestaurantRepositoryImpl): RestaurantRepository

    @Binds
    @Singleton
    abstract fun bindCartRepository(impl: CartRepositoryImpl): CartRepository

    @Binds
    @Singleton
    abstract fun bindOrderRepository(impl: OrderRepositoryImpl): OrderRepository

    @Binds
    @Singleton
    abstract fun bindDeliveryRepository(impl: DeliveryRepositoryImpl): DeliveryRepository
}

@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {

    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideFirebaseFirestore(): FirebaseFirestore = FirebaseFirestore.getInstance()

    @Provides
    @Singleton
    fun provideFirebaseFunctions(): FirebaseFunctions = FirebaseFunctions.getInstance("asia-south1")

    @Provides
    @Singleton
    fun provideSimulatedLocationEngine(): SimulatedLocationEngine = SimulatedLocationEngine()
}
