package com.maruchin.gymster.data.exercises

import com.maruchin.gymster.data.common.model.PaginatedListJson
import com.maruchin.gymster.data.exercises.json.ExerciseBaseInfoJson
import com.maruchin.gymster.data.exercises.mapper.toDomain
import com.maruchin.gymster.data.exercises.model.ExerciseBase
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

internal class ExercisesBaseRepository(private val httpClient: HttpClient) {

    suspend fun getAllExercises(): List<ExerciseBase> {
        val responseJson = httpClient.get("/api/v2/exercisebaseinfo/") {
            parameter("limit", EXERCISES_LIMIT)
        }.body<PaginatedListJson<ExerciseBaseInfoJson>>()
        return responseJson.results.map { it.toDomain() }
    }

    companion object {

        const val EXERCISES_LIMIT = 1_000
    }
}
