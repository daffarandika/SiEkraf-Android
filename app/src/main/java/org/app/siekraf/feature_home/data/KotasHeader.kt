package org.app.siekraf.feature_home.data

import kotlinx.serialization.Serializable
import org.app.siekraf.core.model.Uploader

@Serializable
data class KotasHeader (
    val id: Int = 1,
    val gambar: String? = null,
    val judul: String = "Judul",
    val tanggal: String = "2015-10-27T16:22:27.605-07:00Q",
    val uploader: Uploader = Uploader()
)
