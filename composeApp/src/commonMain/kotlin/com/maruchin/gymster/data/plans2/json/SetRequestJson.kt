package com.maruchin.gymster.data.plans2.json

import com.maruchin.gymster.data.plans2.model.AddExerciseTemplateRequest
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class SetRequestJson(@SerialName("exerciseday") val exerciseDay: Int)

internal fun AddExerciseTemplateRequest.toJson() = SetRequestJson(exerciseDay = workoutTemplateId)
