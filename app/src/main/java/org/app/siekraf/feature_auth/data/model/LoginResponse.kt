package org.app.siekraf.feature_auth.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    @SerialName("Role")
    val role: String,
    @SerialName("Token")
    val token: String
)
