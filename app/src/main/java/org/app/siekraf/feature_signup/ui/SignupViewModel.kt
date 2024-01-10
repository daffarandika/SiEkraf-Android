package org.app.siekraf.feature_signup.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.app.siekraf.core.model.Output
import org.app.siekraf.feature_signup.data.SignupUiState

class SignupViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(SignupUiState())
    val uiState: StateFlow<SignupUiState> = _uiState.asStateFlow()

    private val _signupState = MutableStateFlow<Output<String>>(Output.Loading)
    val  signupState: StateFlow<Output<String>> = _signupState.asStateFlow()

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

    fun updateNameInput(name: String) {
        _uiState.update {
            it.copy(name = name)
        }
    }

    fun updatePasswordVisibility(isPasswordVisible: Boolean) {
        _uiState.update {
            it.copy(isPasswordVisible = isPasswordVisible)
        }
    }

    fun updateGenderRadioIndex(index: Int) {
        _uiState.update {
            it.copy(selectedGenderRadioIndex = index)
        }
    }

    fun updateRoleRadioIndex(index: Int) {
        _uiState.update {
            it.copy(selectedRoleRadioIndex = index)
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

    fun updateNameError(isNameError: Boolean) {
        _uiState.update {
            it.copy(isNameError = isNameError)
        }
    }

    fun isReadyToLogin(): Boolean = (uiState.value.email.isNotBlank() and uiState.value.password.isNotBlank())
}