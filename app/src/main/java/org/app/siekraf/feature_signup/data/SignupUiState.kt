package org.app.siekraf.feature_signup.data

data class SignupUiState(
    val email: String = "",
    val password: String = "",
    val name: String = "",
    val isPasswordVisible: Boolean = false,
    val isEmailError: Boolean = false,
    val isNameError: Boolean = false,
    val isPasswordError: Boolean = false,
    val genderRadioValue: List<String> = listOf("Pria", "Wanita"),
    val selectedGenderRadioIndex: Int = -1,
    val roleRadioValue: List<String> = listOf("Penjual", "Pengusaha"),
    val selectedRoleRadioIndex: Int = -1,
)
