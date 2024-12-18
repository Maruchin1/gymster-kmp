package com.maruchin.gymster.data.plans2.json

import com.maruchin.gymster.data.plans2.model.AddSetTemplateRequest
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class SettingRequestJson(
    val set: Int,
    @SerialName("exercise_base") val exerciseBase: Int,
    val reps: Int
)

internal fun AddSetTemplateRequest.toJson() = SettingRequestJson(
    set = exerciseTemplateId,
    exerciseBase = exerciseBaseId,
    reps = 0
)
