package org.app.siekraf.feature_profile.data

data class ProfileUiState(
    val email: String = "email",
    val name: String = "nama",
    val phone: String = "81271233890",
    val genderRadioValue: List<String> = listOf("Pria", "Wanita"),
    val selectedGenderRadioIndex: Int = -1,
    val canEditName: Boolean = false,
    val canEditEmail: Boolean = false,
    val canEditPhone: Boolean = false,
)
