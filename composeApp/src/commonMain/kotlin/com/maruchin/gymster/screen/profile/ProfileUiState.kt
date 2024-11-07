package com.maruchin.gymster.screen.profile

import com.maruchin.gymster.data.userprofile.model.UserProfile

internal data class ProfileUiState(
    val userProfile: UserProfile? = null,
    val isLoggedIn: Boolean? = null,
    val isLoading: Boolean = true
)
