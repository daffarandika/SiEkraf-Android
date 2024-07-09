package org.app.siekraf.feature_home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import org.app.siekraf.core.model.Output
import org.app.siekraf.feature_home.data.HomeRepository
import org.app.siekraf.feature_home.data.KotasHeader
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository
): ViewModel() {

    private val _uiState = MutableStateFlow<Output<List<KotasHeader>>>(Output.Loading)
    val uiState: StateFlow<Output<List<KotasHeader>>> = _uiState.asStateFlow()

    init {
        getKotas()
    }

    fun getKotas() {
        viewModelScope.launch {
            homeRepository.getKotas()
                .onStart {
                    _uiState.value = Output.Loading
                }.catch {err ->
                    _uiState.value = Output.Error(err)
                }.collect { res ->
                    _uiState.value = Output.Success(res.data)
                }
        }
    }

}
