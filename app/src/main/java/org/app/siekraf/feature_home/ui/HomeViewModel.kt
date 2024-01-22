package org.app.siekraf.feature_home.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.update
import org.app.siekraf.core.model.Aspirasi
import org.app.siekraf.core.model.Output
import org.app.siekraf.feature_auth.data.TokenRepository
import org.app.siekraf.feature_home.data.HomeUiState
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val tokenRepository: TokenRepository
): ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    private val _outputState = MutableStateFlow<Output<List<Aspirasi>>>(Output.Loading)
    val outputState: StateFlow<Output<List<Aspirasi>>> = _outputState.asStateFlow()

    fun updateAspirasi(listAspirasi: List<Aspirasi>) {
        _uiState.value = uiState.value.copy(
            listApsirasi = listAspirasi
        )
    }

    fun getToken(): Flow<String> {
        return tokenRepository.token.filter {
            it != ""
        }
    }

    fun updateSaldo(saldo: Int) {
        _uiState.update {
            it.copy(saldo = saldo)
        }
    }

}
