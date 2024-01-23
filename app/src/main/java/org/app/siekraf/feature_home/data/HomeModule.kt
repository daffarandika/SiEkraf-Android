package org.app.siekraf.feature_home.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import org.app.siekraf.core.network.Constants
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeModule {
    @Provides
    @Singleton
    fun provideHomeApiService(
        @Named("Token Interceptor Client") client: OkHttpClient
    ): HomeApiService {
        return Retrofit.Builder()
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .baseUrl(Constants.BASE_URL)
            .client(client)
            .build()
            .create(HomeApiService::class.java)
    }
}