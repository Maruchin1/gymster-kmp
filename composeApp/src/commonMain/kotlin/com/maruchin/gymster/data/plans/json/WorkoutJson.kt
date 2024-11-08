package com.maruchin.gymster.data.plans.json

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class WorkoutJson(
    val id: Int,
    val name: String,
    @SerialName("creation_date") val creationDate: String
)
