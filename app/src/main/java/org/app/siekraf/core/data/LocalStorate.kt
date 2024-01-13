package org.app.siekraf.core.data

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.map
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow

class LocalStorage(private val context: Context) {
    companion object {
        val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "LocalStorage")
        val TOKEN_KEY = stringPreferencesKey("token")
        val CART_ITEMS_KEY = stringPreferencesKey("cart_items")
        val EMAIL_KEY = stringPreferencesKey("email")
        val PASSWORD_KEY = stringPreferencesKey("password")
    }


    val token = context.dataStore.data.map {
        it[TOKEN_KEY] ?: ""
    }
    val email = context.dataStore.data.map {
        it[EMAIL_KEY] ?: ""
    }
    val password = context.dataStore.data.map {
        it[PASSWORD_KEY] ?: ""
    }
    suspend fun clearToken() {
        setToken("")
    }
    suspend fun setEmail(email: String) {
        context.dataStore.edit {
            it[EMAIL_KEY] = email
        }
    }
    suspend fun setPassword(password: String) {
        context.dataStore.edit {
            it[PASSWORD_KEY] = password
        }
    }
    val produkIdInCart: Flow<String> = context.dataStore.data
        .map {
            it[CART_ITEMS_KEY] ?: ""
        }
    suspend fun setToken(token: String) {
        context.dataStore.edit {
            it[TOKEN_KEY] = token
        }
    }
    suspend fun removeItemFromCart(bookId: String) {
        context.dataStore.edit {
            if(it[CART_ITEMS_KEY]!!.contains(bookId)) {
                Log.e(":", "removeItemFromCart: ${it[CART_ITEMS_KEY]!!.split(";").filter { curr ->
                    curr != bookId
                }}", )
                it[CART_ITEMS_KEY] = it[CART_ITEMS_KEY]!!.split(";").filter { curr ->
                    curr != bookId
                }.joinToString(";")
                Log.e("TAG", "removeItemFromCart: $bookId now list looks like this ${it[CART_ITEMS_KEY]}", )
            }
        }
    }
    suspend fun addItemToCart(produkId: String) {
        if (produkId.isEmpty()) return
        context.dataStore.edit {
            if (it[CART_ITEMS_KEY] == "") {
                it[CART_ITEMS_KEY] = produkId
            } else {
                val bookIds = (it[CART_ITEMS_KEY] ?: "").split(";").toMutableSet()
                bookIds.add(produkId)
                it[CART_ITEMS_KEY] = bookIds.joinToString(";")
            }
        }
    }
    suspend fun clearCartItems(){
        context.dataStore.edit {
            it[CART_ITEMS_KEY] = ""
        }
    }
}
