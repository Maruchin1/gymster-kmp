package com.maruchin.gymster.data.plans2.json

import kotlinx.serialization.Serializable

@Serializable
internal data class WorkoutJson(
    val id: Int,
    val name: String
)
