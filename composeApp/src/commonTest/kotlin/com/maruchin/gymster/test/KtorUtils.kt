package com.maruchin.gymster.test

import io.ktor.client.engine.mock.MockRequestHandleScope
import io.ktor.client.engine.mock.respond
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf

internal fun MockRequestHandleScope.respondJson(
    json: String,
    status: HttpStatusCode = HttpStatusCode.OK
) = respond(
    content = json,
    status = status,
    headers = headersOf(
        HttpHeaders.ContentType,
        ContentType.Application.Json.toString()
    )
)
