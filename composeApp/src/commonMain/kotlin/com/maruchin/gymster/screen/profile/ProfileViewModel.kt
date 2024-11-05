package com.maruchin.gymster.screen.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.touchlab.kermit.Logger
import com.maruchin.gymster.data.session.SessionRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

internal class ProfileViewModel(private val sessionRepository: SessionRepository) : ViewModel() {

    val uiState: StateFlow<ProfileUiState> = sessionRepository.observeSession()
        .map { ProfileUiState(it) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = ProfileUiState()
        )

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Logger.e("ProfileViewModel", throwable) { "Error in ProfileViewModel" }
    }

    fun logout() = viewModelScope.launch(exceptionHandler) {
        sessionRepository.logout()
    }
}
