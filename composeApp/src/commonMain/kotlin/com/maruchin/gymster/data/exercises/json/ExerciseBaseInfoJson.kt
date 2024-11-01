package com.maruchin.gymster.data.exercises.json

import kotlinx.serialization.Serializable

@Serializable
internal data class ExerciseBaseInfoJson(
    val id: Int,
    val uuid: String,
    val category: ExerciseCategoryJson,
    val images: List<ExerciseImageJson>,
    val exercises: List<ExerciseTranslationBaseInfoJson>
)
