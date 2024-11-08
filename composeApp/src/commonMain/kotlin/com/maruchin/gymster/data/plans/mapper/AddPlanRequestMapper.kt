package com.maruchin.gymster.data.plans.mapper

import com.maruchin.gymster.data.plans.json.WorkoutRequestJson
import com.maruchin.gymster.data.plans.model.AddPlanRequest

internal fun AddPlanRequest.toJson() = WorkoutRequestJson(name = name)
