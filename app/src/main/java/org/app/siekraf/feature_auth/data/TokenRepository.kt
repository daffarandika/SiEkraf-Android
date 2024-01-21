package org.app.siekraf.feature_auth.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TokenRepository @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {
    private val TOKEN_KEY = stringPreferencesKey("token")
    val token = dataStore.data.map {
        it[TOKEN_KEY] ?: ""
    }
    suspend fun setToken(token: String) {
       dataStore.edit {
            it[TOKEN_KEY] = token
        }
    }
    suspend fun clearToken() {
        setToken("")
    }
}