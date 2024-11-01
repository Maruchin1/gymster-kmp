package com.maruchin.gymster.data.exercises

import com.maruchin.gymster.data.exercises.json.PaginatedExerciseBaseInfoListJson
import com.maruchin.gymster.data.exercises.mapper.toDomain
import com.maruchin.gymster.data.exercises.model.Exercise
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

internal class ExercisesRepository(private val httpClient: HttpClient) {

    suspend fun getExercises(pageIndex: Int, categoryId: Int?): List<Exercise> {
        val response = httpClient.get("/api/v2/exercisebaseinfo/") {
            parameter("offset", pageIndex)
            parameter("category", categoryId)
        }
        val responseBody = response.body<PaginatedExerciseBaseInfoListJson>()
        return responseBody.results.map { it.toDomain() }
    }
}
