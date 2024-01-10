package org.app.siekraf.feature_home.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.app.siekraf.core.model.Aspirasi
import org.app.siekraf.core.model.Output
import org.app.siekraf.feature_home.data.HomeUiState

data class UiState(val isLoading: Boolean, val data: List<Aspirasi>? = null, val error: String? = null)


class HomeViewModel(): ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    private val _outputState = MutableStateFlow<Output<List<Aspirasi>>>(Output.Loading)
    val outputState: StateFlow<Output<List<Aspirasi>>> = _outputState.asStateFlow()

    fun updateAspirasi(listAspirasi: List<Aspirasi>) {
        _uiState.value = uiState.value.copy(
            listApsirasi = listAspirasi
        )
    }

    fun updateSaldo(saldo: Int) {
        _uiState.update {
            it.copy(saldo = saldo)
        }
    }

}
