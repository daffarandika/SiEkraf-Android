package org.app.siekraf.feature_home.data

import retrofit2.http.GET
import retrofit2.http.Headers

interface HomeApiService {

    @GET("kotas")
    @Headers("Accept: application/json")
    suspend fun getKotas(): KotasResponse
}