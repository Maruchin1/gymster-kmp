package com.maruchin.gymster.data.plans2.api

import com.maruchin.gymster.core.preferences.SessionStore
import com.maruchin.gymster.core.utils.tokenAuth
import com.maruchin.gymster.data.common.model.PaginatedListJson
import com.maruchin.gymster.data.plans2.json.DayJson
import com.maruchin.gymster.data.plans2.json.DayRequestJson
import com.maruchin.gymster.data.plans2.json.PatchedDayRequestJson
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.patch
import io.ktor.client.request.post
import io.ktor.client.request.setBody

internal class DayApi(
    private val httpClient: HttpClient,
    private val sessionStore: SessionStore
) {
    suspend fun get(workoutId: Int? = null): PaginatedListJson<DayJson> {
        return httpClient.get("/api/v2/day/") {
            tokenAuth(sessionStore.getToken())
            parameter("limit", value = 1_000)
            parameter("training", workoutId)
        }.body()
    }

    suspend fun get(id: Int): DayJson? {
        return httpClient.get("/api/v2/day/$id/") {
            tokenAuth(sessionStore.getToken())
        }.body()
    }

    suspend fun post(body: DayRequestJson): DayJson {
        return httpClient.post("/api/v2/day/") {
            tokenAuth(sessionStore.getToken())
            setBody(body)
        }.body()
    }

    suspend fun patch(id: Int, body: PatchedDayRequestJson): DayJson {
        return httpClient.patch("/api/v2/day/$id/") {
            tokenAuth(sessionStore.getToken())
            setBody(body)
        }.body()
    }

    suspend fun delete(id: Int) {
        httpClient.delete("/api/v2/day/$id/") {
            tokenAuth(sessionStore.getToken())
        }
    }
}
