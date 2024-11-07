package com.maruchin.gymster.data.session.model

internal sealed interface LoginResult {

    data object Success : LoginResult

    data object InvalidCredentials : LoginResult
}
