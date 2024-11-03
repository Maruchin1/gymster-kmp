package com.maruchin.gymster.screen.login

internal data class LoginUiState(val isSubmitting: Boolean = false, val result: LoginResult? = null)

internal enum class LoginResult {
    INVALID_CREDENTIALS,
    SUCCESS
}
