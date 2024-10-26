package com.maruchin.gymster.data.plans.model

import kotlin.uuid.Uuid

internal data class PlanTraining(
    val id: String = Uuid.random().toString(),
    val name: String,
    val exercises: List<PlanExercise>
)
