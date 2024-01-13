package org.app.siekraf.feature_profile.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.app.siekraf.core.model.Output
import org.app.siekraf.feature_profile.data.ProfileUiState
import org.app.siekraf.feature_signup.data.SignupUiState

class ProfileViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    private val _profileState = MutableStateFlow<Output<String>>(Output.Loading)
    val  profilState: StateFlow<Output<String>> = _profileState.asStateFlow()

    fun updateEmailInput(email: String) {
        _uiState.update{
            it.copy(email = email)
        }
    }

    fun updateNameInput(name: String) {
        _uiState.update {
            it.copy(name = name)
        }
    }

    fun updatePhoneInput(phone: String) {
        _uiState.update {
            it.copy(phone = phone)
        }
    }

    fun updateNameEditability(canEdit: Boolean){
        _uiState.update {
            it.copy(canEditName = canEdit)
        }
    }
    fun updateEmailEditability(canEdit: Boolean){
        _uiState.update {
            it.copy(canEditEmail = canEdit)
        }
    }
    fun updatePhoneEditability(canEdit: Boolean){
        _uiState.update {
            it.copy(canEditPhone = canEdit)
        }
    }
}