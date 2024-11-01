package com.maruchin.gymster.data.exercises.model

internal data class Exercise(
    val id: Int,
    val name: String,
    val description: String,
    val category: ExerciseCategory,
    val images: List<String>
)
