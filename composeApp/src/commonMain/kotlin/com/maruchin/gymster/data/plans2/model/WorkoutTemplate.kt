package com.maruchin.gymster.data.plans2.model

internal data class WorkoutTemplate(
    val id: Int,
    val name: String,
    val exercises: List<ExerciseTemplate>
)
