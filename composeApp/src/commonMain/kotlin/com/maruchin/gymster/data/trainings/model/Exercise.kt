package com.maruchin.gymster.data.trainings.model

internal data class Exercise(
    val id: Int,
    val exerciseBaseId: Int,
    val name: String,
    val sets: List<ExerciseSet>
)
