package com.maruchin.gymster.data.plans2.json

import com.maruchin.gymster.data.plans2.model.RenameWorkoutTemplateRequest
import kotlinx.serialization.Serializable

@Serializable
internal data class PatchedDayRequestJson(val description: String)

internal fun RenameWorkoutTemplateRequest.toJson() = PatchedDayRequestJson(description = newName)
