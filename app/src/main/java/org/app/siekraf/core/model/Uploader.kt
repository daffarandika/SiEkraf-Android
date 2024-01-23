package org.app.siekraf.core.model

import kotlinx.serialization.Serializable

@Serializable
data class Uploader(
    val id: Int = -1,
    val nama: String = "Hamba Allah"
)
