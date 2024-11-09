package com.maruchin.gymster.core.utils

import io.ktor.client.request.header
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMessageBuilder

internal fun HttpMessageBuilder.tokenAuth(token: String?) {
    header(HttpHeaders.Authorization, "Token $token")
}
