package org.app.siekraf.feature_home.data

import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun getKotas(): Flow<KotasResponse>
}