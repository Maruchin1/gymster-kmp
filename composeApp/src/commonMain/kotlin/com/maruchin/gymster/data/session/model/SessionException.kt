package com.maruchin.gymster.data.session.model

internal sealed class SessionException : RuntimeException()

internal class InvalidCredentialsException : SessionException()
