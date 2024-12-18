package com.maruchin.gymster.data.plans2.mapper

import com.maruchin.gymster.data.plans2.json.DayRequestJson
import com.maruchin.gymster.data.plans2.model.AddWorkoutTemplateRequest

internal fun AddWorkoutTemplateRequest.toJson() = DayRequestJson(
    training = planId,
    description = name,
    day = emptyList()
)
