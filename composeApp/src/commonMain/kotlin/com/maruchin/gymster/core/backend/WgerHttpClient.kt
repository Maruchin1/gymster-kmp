package com.maruchin.gymster.core.backend

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

internal fun wgerHttpClient(engine: HttpClientEngine) = HttpClient(engine) {
    expectSuccess = true
    defaultRequest {
        url("https://wger.de")
        contentType(ContentType.Application.Json)
    }
    install(ContentNegotiation) {
        json(
            Json {
                ignoreUnknownKeys = true
            }
        )
    }
    install(Logging) {
        logger = kermitLogger()
    }
}
