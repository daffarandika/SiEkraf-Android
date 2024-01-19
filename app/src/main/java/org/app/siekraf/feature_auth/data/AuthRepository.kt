package org.app.siekraf.feature_auth.data

import kotlinx.coroutines.flow.Flow
import org.app.siekraf.core.model.Output

interface AuthRepository {
    suspend fun login(loginRequest: LoginRequest): Flow<LoginResponse>
}