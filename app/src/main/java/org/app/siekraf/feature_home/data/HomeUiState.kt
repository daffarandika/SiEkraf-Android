package org.app.siekraf.feature_home.data

import org.app.siekraf.core.model.Aspirasi

data class HomeUiState(
    val listApsirasi: List<Aspirasi> = listOf(),
    val saldo: Int = 0,
)
