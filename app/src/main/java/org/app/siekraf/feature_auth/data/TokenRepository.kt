package org.app.siekraf.feature_auth.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import dagger.hilt.android.qualifiers.ActivityContext
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TokenRepository @Inject constructor(
    val dataStore: DataStore<Preferences>
) {
    val TOKEN_KEY = stringPreferencesKey("token")
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