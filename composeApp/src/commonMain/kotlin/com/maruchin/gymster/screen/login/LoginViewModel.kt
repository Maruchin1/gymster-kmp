package com.maruchin.gymster.screen.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.touchlab.kermit.Logger
import com.maruchin.gymster.data.session.SessionRepository
import com.maruchin.gymster.data.session.model.LoginRequest
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class LoginViewModel(private val sessionRepository: SessionRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState = _uiState.asStateFlow()

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Logger.e(tag = "LoginViewModel", throwable) { "Error during login" }
    }

    fun login(request: LoginRequest) = viewModelScope.launch(exceptionHandler) {
        _uiState.update {
            it.copy(isSubmitting = true)
        }
        val result = sessionRepository.login(request)
        _uiState.update {
            it.copy(isSubmitting = false, result = result)
        }
    }
}
