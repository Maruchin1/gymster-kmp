package com.maruchin.gymster.data.trainings.json

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class SettingRequestJson(
    val set: Int,
    @SerialName("exercise_base") val exerciseBase: Int,
    val reps: Int
)
