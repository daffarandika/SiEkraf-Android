package org.app.siekraf.feature_auth.data

data class LoginUiState(
    val email: String = "solo@gmail.com",
    val password: String = "12345678",
    val isPasswordVisible: Boolean = false,
    val isEmailError: Boolean = false,
    val isPasswordError: Boolean = false,
)
