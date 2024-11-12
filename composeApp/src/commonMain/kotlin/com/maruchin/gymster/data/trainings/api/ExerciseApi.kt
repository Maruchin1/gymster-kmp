package com.maruchin.gymster.data.trainings.api

import com.maruchin.gymster.data.exercises.json.ExerciseBaseInfoJson
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

internal class ExerciseApi(private val httpClient: HttpClient) {

    suspend fun getExercise(id: Int): ExerciseBaseInfoJson =
        httpClient.get("/api/v2/exercisebaseinfo/$id").body()
}
