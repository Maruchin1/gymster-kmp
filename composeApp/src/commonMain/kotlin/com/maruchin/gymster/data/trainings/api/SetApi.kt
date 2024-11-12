package com.maruchin.gymster.data.trainings.api

import com.maruchin.gymster.core.preferences.SessionStore
import com.maruchin.gymster.core.utils.tokenAuth
import com.maruchin.gymster.data.common.model.PaginatedListJson
import com.maruchin.gymster.data.trainings.json.SetJson
import com.maruchin.gymster.data.trainings.json.SetRequestJson
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.accept
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

internal class SetApi(private val httpClient: HttpClient, private val sessionStore: SessionStore) {

    suspend fun getSets(dayIds: List<Int>): List<SetJson> = coroutineScope {
        dayIds.map { async { getSets(it) } }
            .awaitAll()
            .flatten()
    }

    suspend fun getSets(day: Int): List<SetJson> = httpClient.get("/api/v2/set/") {
        tokenAuth(sessionStore.getToken())
        parameter("exerciseday", day)
        parameter("limit", 100)
    }.body<PaginatedListJson<SetJson>>().results

    suspend fun addSet(request: SetRequestJson): SetJson = httpClient.post("/api/v2/set/") {
        tokenAuth(sessionStore.getToken())
        accept(ContentType.Application.Json)
        setBody(request)
    }.body()
}
