package com.maruchin.gymster.data.trainings.json

import kotlinx.serialization.Serializable

@Serializable
internal data class DayJson(val id: Int, val description: String)
