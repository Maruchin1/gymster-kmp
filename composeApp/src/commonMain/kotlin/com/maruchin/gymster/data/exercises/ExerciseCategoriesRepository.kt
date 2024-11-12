package com.maruchin.gymster.data.exercises

import com.maruchin.gymster.data.common.model.PaginatedListJson
import com.maruchin.gymster.data.exercises.json.ExerciseCategoryJson
import com.maruchin.gymster.data.exercises.mapper.toDomain
import com.maruchin.gymster.data.exercises.model.ExerciseCategory
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

internal class ExerciseCategoriesRepository(private val httpClient: HttpClient) {

    suspend fun getAllExerciseCategories(): List<ExerciseCategory> {
        val responseJson = httpClient.get("/api/v2/exercisecategory/")
            .body<PaginatedListJson<ExerciseCategoryJson>>()
        return responseJson.results.map { it.toDomain() }
    }
}
