package uz.uni_team.registration.ui.main

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RegistrationViewModel : ViewModel() {

    private val _state: MutableStateFlow<RegistrationUiState> =
        MutableStateFlow(RegistrationUiState())
    val state: StateFlow<RegistrationUiState> = _state.asStateFlow()

    fun incrementCount() {
        val count = _state.value.count + 1
        _state.update {
            it.copy(
                count = count
            )
        }
    }

    fun decrementCount() {
        val count = _state.value.count - 1
        _state.update {
            it.copy(
                count = count
            )
        }
    }

    data class RegistrationUiState(
        val count: Int = 0
    )
}