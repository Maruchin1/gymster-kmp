package com.maruchin.gymster.data.plans.model

import kotlin.uuid.Uuid

internal data class PlanExercise(
    val id: String = Uuid.random().toString(),
    val name: String,
    val sets: Int,
    val reps: IntRange
)
