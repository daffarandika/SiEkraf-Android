package org.app.siekraf.feature_auth.data.network

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.app.siekraf.feature_auth.data.model.LoginRequest
import org.app.siekraf.feature_auth.data.model.LoginResponse
import org.app.siekraf.feature_auth.data.model.SignupResponse
import org.app.siekraf.feature_auth.data.network.AuthApiService
import org.app.siekraf.feature_auth.data.network.AuthRepository
import javax.inject.Inject

class NetworkAuthRepository @Inject constructor(
    private val apiService: AuthApiService
): AuthRepository {
    override suspend fun login(loginRequest: LoginRequest): Flow<LoginResponse> {
        return flow {
            emit(apiService.login(loginRequest))
        }
    }

    override suspend fun signup(loginRequest: LoginRequest): Flow<SignupResponse> {
        return flow {
            emit(apiService.signUp(loginRequest))
        }
    }
}