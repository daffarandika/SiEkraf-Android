package org.app.siekraf.feature_home.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NetworkHomeRepository @Inject constructor(
    private val apiService: HomeApiService
): HomeRepository {
    override suspend fun getKotas(): Flow<KotasResponse> {
        return flow {
            emit(apiService.getKotas())
        }
    }
}