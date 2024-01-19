package org.app.siekraf.feature_auth.data

import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthApiService {
    @POST("masuk")
    @Headers("Accept: application/json")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse
}