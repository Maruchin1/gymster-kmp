package com.maruchin.gymster.screen.login

internal data class LoginUiState(val isLoggedIn: Boolean = false, val message: LoginMessage? = null)

internal enum class LoginMessage {
    INVALID_CREDENTIALS
}
