package org.app.siekraf.feature_auth.data.network

import org.app.siekraf.feature_auth.data.model.LoginRequest
import org.app.siekraf.feature_auth.data.model.LoginResponse
import org.app.siekraf.feature_auth.data.model.SignupResponse
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthApiService {
    @POST("masuk")
    @Headers("Accept: application/json")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse

    @POST("daftar")
    @Headers("Accept: application/json")
    suspend fun signUp(@Body loginRequest: LoginRequest): SignupResponse
}