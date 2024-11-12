package com.maruchin.gymster.data.exercises.model

internal data class ExerciseBase(
    val id: Int,
    val name: String,
    val description: String,
    val category: ExerciseCategory,
    val images: List<String>
)
