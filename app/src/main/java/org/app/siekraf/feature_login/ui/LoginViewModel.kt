package org.app.siekraf.feature_login.ui

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.app.siekraf.core.data.LocalStorage
import org.app.siekraf.core.model.Output
import org.app.siekraf.feature_login.data.ApiService
import org.app.siekraf.feature_login.data.LoginUiState

class LoginViewModel(
    context: Context
): ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    private val _loginState = MutableStateFlow<Output<String>>(Output.Loading)
    val  loginState: StateFlow<Output<String>> = _loginState.asStateFlow()

    private val dataStore = LocalStorage(context)

    fun updateEmailInput(email: String) {
        _uiState.update{
            it.copy(email = email)
        }
    }
    fun isReadyToLogin(): Boolean = (uiState.value.email.isNotBlank() and uiState.value.password.isNotBlank())

    fun getAndSaveToken() {
        val apiService = ApiService()
        viewModelScope.launch {
            apiService.getToken(
                uiState.value.email,
                uiState.value.password
            ).onStart {
                _loginState.value = Output.Loading
            }.catch { e ->
                _loginState.value = Output.Error(exception = e)
            }.collect { response ->
                dataStore.setToken(response)
                dataStore.setEmail(uiState.value.email)
                dataStore.setPassword(uiState.value.password)
                _loginState.value = Output.Success(response)
            }
        }
        Log.e("TAG", "LoginViewModel: ${_uiState.value}")
    }

    val token = dataStore.token

    fun updatePasswordInput(password: String) {
        _uiState.update {
            it.copy(password = password)
        }
    }

    fun updatePasswordVisibility(isPasswordVisible: Boolean) {
        _uiState.update {
            it.copy(isPasswordVisible = isPasswordVisible)
        }
    }
    fun updatePasswordError(isPasswordError: Boolean) {
        _uiState.update {
            it.copy(isPasswordError = isPasswordError)
        }
    }
    fun updateEmailError(isEmailError: Boolean) {
        _uiState.update {
            it.copy(isEmailError = isEmailError)
        }
    }

}