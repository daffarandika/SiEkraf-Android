package org.app.siekraf.feature_auth.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.app.siekraf.core.model.Output
import org.app.siekraf.feature_auth.data.AuthRepository
import org.app.siekraf.feature_auth.data.LoginRequest
import org.app.siekraf.feature_auth.data.LoginUiState
import org.app.siekraf.feature_auth.data.TokenRepository
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val tokenRepository: TokenRepository,
    private val authRepository: AuthRepository
): ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun updateEmailInput(email: String) {
        _uiState.update{
            it.copy(email = email)
        }
    }

    fun login() {
        viewModelScope.launch {
            val loginRequest = LoginRequest(
                email = uiState.value.email,
                password = uiState.value.password
            )
            authRepository.login(loginRequest).onStart {
                _uiState.update {
                    it.copy(token = Output.Loading)
                }
            }.catch { e ->
                _uiState.update {
                    it.copy(token = Output.Error(e))
                }
            }.collect { res ->
                tokenRepository.setToken(res.token)
                _uiState.update {
                    it.copy(token = Output.Success(res.token))
                }
            }
        }
    }

    val isReadyToLogin: Boolean = (uiState.value.email.isNotBlank() and uiState.value.password.isNotBlank())

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