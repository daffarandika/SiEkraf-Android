package org.app.siekraf.feature_home.data

import kotlinx.serialization.Serializable

@Serializable
data class KotasResponse(
    val data: List<KotasHeader>
)
