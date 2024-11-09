package com.maruchin.gymster.data.trainings.mapper

import com.maruchin.gymster.data.trainings.json.DayRequestJson
import com.maruchin.gymster.data.trainings.model.AddTrainingRequest

internal fun AddTrainingRequest.toJson() = DayRequestJson(
    training = planId,
    description = name,
    day = emptyList()
)
