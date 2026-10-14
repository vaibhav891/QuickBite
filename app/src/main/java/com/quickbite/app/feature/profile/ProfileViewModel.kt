package com.quickbite.app.feature.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quickbite.app.domain.model.UserProfile
import com.quickbite.app.domain.model.UserRole
import com.quickbite.app.domain.repository.AuthRepository
import com.quickbite.app.domain.repository.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ProfileUiState(
    val user: UserProfile,
    val notificationsEnabled: Boolean = true,
    val isSeeding: Boolean = false,
    val seedSuccess: Boolean? = null
)

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val restaurantRepository: RestaurantRepository
) : ViewModel() {

    val currentUser: StateFlow<UserProfile> = authRepository.currentUser
    val currentRole: StateFlow<UserRole> = authRepository.currentRole

    private val _notificationsEnabled = MutableStateFlow(true)
    val notificationsEnabled: StateFlow<Boolean> = _notificationsEnabled.asStateFlow()

    private val _isSeeding = MutableStateFlow(false)
    val isSeeding: StateFlow<Boolean> = _isSeeding.asStateFlow()

    private val _seedMessage = MutableStateFlow<String?>(null)
    val seedMessage: StateFlow<String?> = _seedMessage.asStateFlow()

    fun switchRole(role: UserRole) {
        authRepository.switchRole(role)
    }

    fun toggleNotifications(enabled: Boolean) {
        _notificationsEnabled.value = enabled
    }

    fun seedDatabase() {
        viewModelScope.launch {
            _isSeeding.value = true
            _seedMessage.value = null
            val result = restaurantRepository.seedFirestoreIfEmpty()
            _isSeeding.value = false
            if (result.isSuccess) {
                _seedMessage.value = "Demo database populated with 5 restaurants and menus!"
            } else {
                _seedMessage.value = "Seeding completed with local fallback data."
            }
        }
    }

    fun signOut() {
        authRepository.signOut()
    }
}
