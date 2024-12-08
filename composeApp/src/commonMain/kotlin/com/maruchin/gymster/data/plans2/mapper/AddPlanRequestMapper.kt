package com.maruchin.gymster.data.plans2.mapper

import com.maruchin.gymster.data.plans2.json.WorkoutRequestJson
import com.maruchin.gymster.data.plans2.model.AddPlanRequest

internal fun AddPlanRequest.toJson() = WorkoutRequestJson(name = name)
