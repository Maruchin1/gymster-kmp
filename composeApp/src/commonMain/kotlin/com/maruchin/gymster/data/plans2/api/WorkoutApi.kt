package com.maruchin.gymster.data.plans2.api

import com.maruchin.gymster.core.preferences.SessionStore
import com.maruchin.gymster.core.utils.tokenAuth
import com.maruchin.gymster.data.common.model.PaginatedListJson
import com.maruchin.gymster.data.plans2.json.WorkoutJson
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

internal class WorkoutApi(
    private val httpClient: HttpClient,
    private val sessionStore: SessionStore
) {

    suspend fun get(): PaginatedListJson<WorkoutJson> {
        return httpClient.get("/api/v2/workout") {
            tokenAuth(sessionStore.getToken())
            parameter("limit", value = 1_000)
        }.body()
    }

    suspend fun get(id: Int): WorkoutJson? {
        return httpClient.get("/api/v2/workout/$id") {
            tokenAuth(sessionStore.getToken())
        }.body()
    }
}
