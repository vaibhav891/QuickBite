package com.quickbite.app.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.quickbite.app.core.common.Constants
import com.quickbite.app.domain.model.UserProfile
import com.quickbite.app.domain.model.UserRole
import com.quickbite.app.domain.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : AuthRepository {

    private val customerProfile = UserProfile(
        id = Constants.DEMO_CUSTOMER_ID,
        name = Constants.DEMO_CUSTOMER_NAME,
        email = Constants.DEMO_CUSTOMER_EMAIL,
        role = UserRole.CUSTOMER
    )

    private val restaurantProfile = UserProfile(
        id = Constants.DEMO_RESTAURANT_ID,
        name = Constants.DEMO_RESTAURANT_NAME,
        email = Constants.DEMO_RESTAURANT_EMAIL,
        role = UserRole.RESTAURANT,
        restaurantId = "rest_01"
    )

    private val deliveryProfile = UserProfile(
        id = Constants.DEMO_RIDER_ID,
        name = Constants.DEMO_RIDER_NAME,
        email = Constants.DEMO_RIDER_EMAIL,
        role = UserRole.DELIVERY_PARTNER,
        deliveryPartnerId = Constants.DEMO_RIDER_ID
    )

    private val _currentUser = MutableStateFlow(customerProfile)
    override val currentUser: StateFlow<UserProfile> = _currentUser.asStateFlow()

    private val _currentRole = MutableStateFlow(UserRole.CUSTOMER)
    override val currentRole: StateFlow<UserRole> = _currentRole.asStateFlow()

    override fun switchRole(role: UserRole) {
        _currentRole.value = role
        _currentUser.value = when (role) {
            UserRole.CUSTOMER -> customerProfile
            UserRole.RESTAURANT -> restaurantProfile
            UserRole.DELIVERY_PARTNER -> deliveryProfile
        }
    }

    override suspend fun signIn(email: String, password: String): Result<UserProfile> {
        return try {
            val result = firebaseAuth.signInWithEmailAndPassword(email, password)
            // If Firebase signs in, update profile
            val uid = result.result?.user?.uid ?: Constants.DEMO_CUSTOMER_ID
            val user = UserProfile(
                id = uid,
                name = result.result?.user?.displayName ?: email.substringBefore("@"),
                email = email,
                role = _currentRole.value,
                isDemoAccount = false
            )
            _currentUser.value = user
            Result.success(user)
        } catch (e: Exception) {
            // Development fallback for demo logins
            val demoUser = UserProfile(
                id = "usr_${email.hashCode()}",
                name = email.substringBefore("@").replaceFirstChar { it.uppercase() },
                email = email,
                role = _currentRole.value,
                isDemoAccount = true
            )
            _currentUser.value = demoUser
            Result.success(demoUser)
        }
    }

    override suspend fun signUp(
        name: String,
        email: String,
        password: String,
        role: UserRole
    ): Result<UserProfile> {
        return try {
            val result = firebaseAuth.createUserWithEmailAndPassword(email, password)
            val uid = result.result?.user?.uid ?: "usr_${System.currentTimeMillis()}"
            val user = UserProfile(
                id = uid,
                name = name,
                email = email,
                role = role,
                isDemoAccount = false
            )
            _currentRole.value = role
            _currentUser.value = user
            Result.success(user)
        } catch (e: Exception) {
            val demoUser = UserProfile(
                id = "usr_${System.currentTimeMillis()}",
                name = name,
                email = email,
                role = role,
                isDemoAccount = true
            )
            _currentRole.value = role
            _currentUser.value = demoUser
            Result.success(demoUser)
        }
    }

    override fun signOut() {
        try {
            firebaseAuth.signOut()
        } catch (_: Exception) {}
        switchRole(UserRole.CUSTOMER)
    }
}
