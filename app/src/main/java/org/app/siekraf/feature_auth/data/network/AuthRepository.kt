package org.app.siekraf.feature_auth.data.network

import kotlinx.coroutines.flow.Flow
import org.app.siekraf.feature_auth.data.model.LoginRequest
import org.app.siekraf.feature_auth.data.model.LoginResponse
import org.app.siekraf.feature_auth.data.model.SignupResponse

interface AuthRepository {
    suspend fun login(loginRequest: LoginRequest): Flow<LoginResponse>
    suspend fun signup(loginRequest: LoginRequest): Flow<SignupResponse>
}