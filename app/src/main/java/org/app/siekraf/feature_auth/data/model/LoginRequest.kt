package org.app.siekraf.feature_auth.data.model

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(
    val email: String = "email",
    val password: String = "pw"
)
