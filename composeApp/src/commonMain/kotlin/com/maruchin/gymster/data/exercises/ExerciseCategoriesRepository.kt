package com.maruchin.gymster.data.exercises

import com.maruchin.gymster.data.exercises.json.PaginatedExerciseCategoryListJson
import com.maruchin.gymster.data.exercises.mapper.toDomain
import com.maruchin.gymster.data.exercises.model.ExerciseCategory
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

internal class ExerciseCategoriesRepository(private val httpClient: HttpClient) {

    suspend fun getAllExerciseCategories(): List<ExerciseCategory> {
        val response = httpClient.get("/api/v2/exercisecategory/")
        val responseBody = response.body<PaginatedExerciseCategoryListJson>()
        return responseBody.results.map { it.toDomain() }
    }
}
