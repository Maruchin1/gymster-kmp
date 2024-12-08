package com.maruchin.gymster.data.plans2.api

import com.maruchin.gymster.core.preferences.SessionStore
import com.maruchin.gymster.core.utils.tokenAuth
import com.maruchin.gymster.data.common.model.PaginatedListJson
import com.maruchin.gymster.data.plans2.json.DayJson
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

internal class DayApi(
    private val httpClient: HttpClient,
    private val sessionStore: SessionStore
) {
    suspend fun get(workoutId: Int? = null): PaginatedListJson<DayJson> {
        return httpClient.get("/api/v2/day") {
            tokenAuth(sessionStore.getToken())
            parameter("limit", value = 1_000)
            parameter("training", workoutId)
        }.body()
    }

    suspend fun get(id: Int): DayJson? {
        return httpClient.get("/api/v2/day/$id") {
            tokenAuth(sessionStore.getToken())
        }.body()
    }
}
