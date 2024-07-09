package org.app.siekraf.feature_auth.data.model

import org.app.siekraf.core.model.Output

data class SignupUiState(
    val email: String = "",
    val password: String = "",
    val name: String = "",
    val phone: String = "",
    val alamat: String = "",
    val isPasswordVisible: Boolean = false,
    val isEmailError: Boolean = false,
    val isNameError: Boolean = false,
    val isPasswordError: Boolean = false,
    val genderRadioValue: List<String> = listOf("Pria", "Wanita"),
    val selectedGenderRadioIndex: Int = -1,
    val roleRadioValue: List<String> = listOf("Penjual", "Pembeli"),
    val selectedRoleRadioIndex: Int = -1,
    val response: Output<SignupResponse> = Output.Loading
)
