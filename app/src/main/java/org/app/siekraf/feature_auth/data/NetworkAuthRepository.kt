package org.app.siekraf.feature_auth.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.app.siekraf.core.model.Output
import javax.inject.Inject

class NetworkAuthRepository @Inject constructor(
    private val apiService: AuthApiService
): AuthRepository {
    override suspend fun login(loginRequest: LoginRequest): Flow<LoginResponse> {
        return flow {
            emit(apiService.login(loginRequest))
        }
    }
}