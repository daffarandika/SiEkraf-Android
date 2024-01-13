package org.app.siekraf.feature_profile.data

data class ProfileUiState(
    val email: String = "email",
    val name: String = "nama",
    val phone: String = "81271233890",
    val image: String = "https://ichef.bbci.co.uk/news/976/cpsprodpb/16620/production/_91408619_55df76d5-2245-41c1-8031-07a4da3f313f.jpg.webp",
    val genderRadioValue: List<String> = listOf("Pria", "Wanita"),
    val selectedGenderRadioIndex: Int = -1,
    val canEditName: Boolean = false,
    val canEditEmail: Boolean = false,
    val canEditPhone: Boolean = false,
)
