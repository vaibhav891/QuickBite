package com.quickbite.app.domain.repository

import com.quickbite.app.domain.model.UserProfile
import com.quickbite.app.domain.model.UserRole
import kotlinx.coroutines.flow.StateFlow

interface AuthRepository {
    val currentUser: StateFlow<UserProfile>
    val currentRole: StateFlow<UserRole>
    fun switchRole(role: UserRole)
    suspend fun signIn(email: String, password: String):Result<UserProfile>
    suspend fun signUp(name: String, email: String, password: String, role: UserRole): Result<UserProfile>
    fun signOut()
}
