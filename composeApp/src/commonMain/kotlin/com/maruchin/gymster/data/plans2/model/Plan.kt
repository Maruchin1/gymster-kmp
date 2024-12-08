package com.maruchin.gymster.data.plans2.model

internal data class Plan(
    val id: Int,
    val name: String,
    val workouts: List<WorkoutTemplate>
)
