package com.maruchin.gymster.data.plans.model

import kotlin.uuid.Uuid

data class Plan(
    val id: String = Uuid.random().toString(),
    val name: String,
    val isActive: Boolean,
    val trainings: List<PlanTraining>
)
