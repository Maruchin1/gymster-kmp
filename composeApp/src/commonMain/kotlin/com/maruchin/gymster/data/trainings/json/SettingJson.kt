package com.maruchin.gymster.data.trainings.json

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class SettingJson(
    val id: Int,
    @SerialName("exercise_base") val exerciseBase: Int,
    val weight: Double?,
    val reps: Int
)
