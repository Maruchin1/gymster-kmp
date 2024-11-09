package com.maruchin.gymster.data.plans.mapper

import com.maruchin.gymster.data.plans.json.PatchedWorkoutRequestJson
import com.maruchin.gymster.data.plans.model.EditPlanRequest

internal fun EditPlanRequest.toJson() = PatchedWorkoutRequestJson(name = name)
