package com.maruchin.gymster.data.plans2.api

import com.maruchin.gymster.core.preferences.SessionStore
import com.maruchin.gymster.core.utils.tokenAuth
import com.maruchin.gymster.data.common.model.PaginatedListJson
import com.maruchin.gymster.data.plans2.json.PatchedWorkoutRequestJson
import com.maruchin.gymster.data.plans2.json.WorkoutJson
import com.maruchin.gymster.data.plans2.json.WorkoutRequestJson
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.patch
import io.ktor.client.request.post
import io.ktor.client.request.setBody

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
        return httpClient.get("/api/v2/workout/$id/") {
            tokenAuth(sessionStore.getToken())
        }.body()
    }

    suspend fun post(body: WorkoutRequestJson): WorkoutJson {
        return httpClient.post("/api/v2/workout/") {
            tokenAuth(sessionStore.getToken())
            setBody(body)
        }.body()
    }

    suspend fun patch(id: Int, body: PatchedWorkoutRequestJson): WorkoutJson {
        return httpClient.patch("/api/v2/workout/$id/") {
            tokenAuth(sessionStore.getToken())
            setBody(body)
        }.body()
    }

    suspend fun delete(id: Int) {
        httpClient.delete("/api/v2/workout/$id/") {
            tokenAuth(sessionStore.getToken())
        }
    }
}
