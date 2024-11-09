package com.maruchin.gymster.data.trainings.json

import kotlinx.serialization.Serializable

@Serializable
internal data class DayRequestJson(val training: Int, val description: String, val day: List<Int>)
