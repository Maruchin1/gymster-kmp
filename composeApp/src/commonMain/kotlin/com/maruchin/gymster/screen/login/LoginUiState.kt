package com.maruchin.gymster.screen.login

import com.maruchin.gymster.data.session.model.LoginResult

internal data class LoginUiState(val isSubmitting: Boolean = false, val result: LoginResult? = null)
