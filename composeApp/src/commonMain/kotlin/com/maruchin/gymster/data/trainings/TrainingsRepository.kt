package com.maruchin.gymster.data.trainings

import com.maruchin.gymster.core.preferences.SessionStore
import com.maruchin.gymster.core.utils.tokenAuth
import com.maruchin.gymster.data.trainings.json.PaginatedDayListJson
import com.maruchin.gymster.data.trainings.mapper.toDomain
import com.maruchin.gymster.data.trainings.mapper.toJson
import com.maruchin.gymster.data.trainings.model.AddTrainingRequest
import com.maruchin.gymster.data.trainings.model.EditTrainingRequest
import com.maruchin.gymster.data.trainings.model.Training
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

internal class TrainingsRepository(
    private val httpClient: HttpClient,
    private val sessionStore: SessionStore
) {

    suspend fun getPlanTrainings(planId: Int): List<Training> {
        val token = sessionStore.getToken()
        val responseJson = httpClient.get("/api/v2/day/") {
            tokenAuth(token)
            parameter("training", planId)
            parameter("limit", 100)
        }.body<PaginatedDayListJson>()
        return responseJson.results.map { it.toDomain() }
    }

    suspend fun addTraining(request: AddTrainingRequest) {
        val token = sessionStore.getToken()
        val requestJson = request.toJson()
        httpClient.post("/api/v2/day/") {
            tokenAuth(token)
            accept(ContentType.Application.Json)
            setBody(requestJson)
        }
    }

    suspend fun editTraining(request: EditTrainingRequest) {
        val token = sessionStore.getToken()
        val requestJson = request.toJson()
        httpClient.patch("/api/v2/day/${request.id}/") {
            tokenAuth(token)
            accept(ContentType.Application.Json)
            setBody(requestJson)
        }
    }

    suspend fun deleteTraining(trainingId: Int) {
        val token = sessionStore.getToken()
        httpClient.delete("/api/v2/day/$trainingId/") {
            tokenAuth(token)
        }
    }
}
