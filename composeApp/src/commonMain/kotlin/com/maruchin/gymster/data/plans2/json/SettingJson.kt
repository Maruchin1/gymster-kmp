package com.maruchin.gymster.data.plans2.json

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class SettingJson(
    val id: Int,
    @SerialName("exercise_base") val exerciseBase: Int,
    val weight: Double?,
    val reps: Int,
    val order: Int
)
