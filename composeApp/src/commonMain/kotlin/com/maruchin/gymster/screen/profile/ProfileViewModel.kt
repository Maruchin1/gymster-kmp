package com.maruchin.gymster.screen.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.touchlab.kermit.Logger
import com.maruchin.gymster.data.session.SessionRepository
import com.maruchin.gymster.data.userprofile.UserProfileRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class ProfileViewModel(
    private val sessionRepository: SessionRepository,
    private val userProfileRepository: UserProfileRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState = _uiState.asStateFlow()

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Logger.e("ProfileViewModel", throwable) { "Error in ProfileViewModel" }
    }

    init {
        observeSession()
        loadUserProfile()
    }

    fun logout() = viewModelScope.launch(exceptionHandler) {
        sessionRepository.logout()
    }

    private fun observeSession() = viewModelScope.launch(exceptionHandler) {
        sessionRepository.isLoggedInFlow.collect { isLoggedIn ->
            _uiState.update {
                it.copy(isLoggedIn = isLoggedIn)
            }
        }
    }

    private fun loadUserProfile() = viewModelScope.launch(exceptionHandler) {
        val userProfile = userProfileRepository.getUserProfile()
        _uiState.update {
            it.copy(userProfile = userProfile, isLoading = false)
        }
    }
}
