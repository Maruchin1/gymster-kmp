package com.maruchin.gymster.data.plans.json

import kotlinx.serialization.Serializable

@Serializable
internal data class PaginatedWorkoutListJson(val results: List<WorkoutJson>)
