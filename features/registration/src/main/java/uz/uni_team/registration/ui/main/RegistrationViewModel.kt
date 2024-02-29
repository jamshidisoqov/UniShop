package uz.uni_team.registration.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import uz.uni_team.domain.auth.AuthUseCase

class RegistrationViewModel(private val authUseCase: AuthUseCase) : ViewModel() {

    private val _state: MutableStateFlow<RegistrationUiState> =
        MutableStateFlow(RegistrationUiState())
    val state: StateFlow<RegistrationUiState> = _state.asStateFlow()


    fun onRegisterClick(phone: String, password: String) {
        viewModelScope.launch {
            runCatching {
                authUseCase.invoke(phone, password)
            }.onSuccess {

            }.onFailure { th ->
                th.printStackTrace()
            }
        }
    }

    data class RegistrationUiState(
        val isLoading: Boolean = false
    )
}