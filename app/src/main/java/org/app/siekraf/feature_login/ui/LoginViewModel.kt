package org.app.siekraf.feature_login.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.app.siekraf.core.model.Output
import org.app.siekraf.feature_login.data.LoginUiState

class LoginViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    private val _loginState = MutableStateFlow<Output<String>>(Output.Loading)
    val  loginState: StateFlow<Output<String>> = _loginState.asStateFlow()

    fun updateEmailInput(email: String) {
        _uiState.update{
            it.copy(email = email)
        }
    }

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

    fun isReadyToLogin(): Boolean = (uiState.value.email.isNotBlank() and uiState.value.password.isNotBlank())
}