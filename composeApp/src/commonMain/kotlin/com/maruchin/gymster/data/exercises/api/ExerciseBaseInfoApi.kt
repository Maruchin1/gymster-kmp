package com.maruchin.gymster.data.exercises.api

import com.maruchin.gymster.core.preferences.SessionStore
import com.maruchin.gymster.core.utils.tokenAuth
import com.maruchin.gymster.data.common.model.PaginatedListJson
import com.maruchin.gymster.data.exercises.json.ExerciseBaseInfoJson
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

internal class ExerciseBaseInfoApi(
    private val httpClient: HttpClient,
    private val sessionStore: SessionStore
) {

    suspend fun get(): PaginatedListJson<ExerciseBaseInfoJson> {
        return httpClient.get("/api/v2/exercisebaseinfo") {
            tokenAuth(sessionStore.getToken())
            parameter("limit", value = 1_000)
        }.body()
    }

    suspend fun get(id: Int): ExerciseBaseInfoJson? {
        return httpClient.get("/api/v2/exercisebaseinfo/$id") {
            tokenAuth(sessionStore.getToken())
        }.body()
    }
}
