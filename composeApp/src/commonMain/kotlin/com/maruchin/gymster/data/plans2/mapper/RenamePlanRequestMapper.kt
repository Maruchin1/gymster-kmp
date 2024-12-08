package com.maruchin.gymster.data.plans2.mapper

import com.maruchin.gymster.data.plans2.json.PatchedWorkoutRequestJson
import com.maruchin.gymster.data.plans2.model.RenamePlanRequest

internal fun RenamePlanRequest.toJson() = PatchedWorkoutRequestJson(name = newName)
