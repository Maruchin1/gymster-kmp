package com.maruchin.gymster.data.exercises.json

import kotlinx.serialization.Serializable

@Serializable
internal data class PaginatedExerciseCategoryListJson(val results: List<ExerciseCategoryJson>)
