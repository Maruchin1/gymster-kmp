package com.maruchin.gymster.data.trainings.api

import com.maruchin.gymster.core.preferences.SessionStore
import com.maruchin.gymster.core.utils.tokenAuth
import com.maruchin.gymster.data.common.model.PaginatedListJson
import com.maruchin.gymster.data.trainings.json.DayJson
import com.maruchin.gymster.data.trainings.json.DayRequestJson
import com.maruchin.gymster.data.trainings.json.PatchedDayRequestJson
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.accept
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.patch
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType

internal class DayApi(private val httpClient: HttpClient, private val sessionStore: SessionStore) {

    suspend fun getDays(training: Int): List<DayJson> = httpClient.get("/api/v2/day/") {
        tokenAuth(sessionStore.getToken())
        parameter("training", training)
        parameter("limit", value = 100)
    }.body<PaginatedListJson<DayJson>>().results

    suspend fun addDay(request: DayRequestJson): DayJson = httpClient.post("/api/v2/day/") {
        tokenAuth(sessionStore.getToken())
        accept(ContentType.Application.Json)
        setBody(request)
    }.body()

    suspend fun updateDay(dayId: Int, request: PatchedDayRequestJson): DayJson =
        httpClient.patch("/api/v2/day/$dayId/") {
            tokenAuth(sessionStore.getToken())
            accept(ContentType.Application.Json)
            setBody(request)
        }.body()

    suspend fun deleteDay(dayId: Int) {
        httpClient.delete("/api/v2/day/$dayId/") {
            tokenAuth(sessionStore.getToken())
        }
    }
}
