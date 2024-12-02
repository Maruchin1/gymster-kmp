package com.maruchin.gymster.data.trainings.mapper

import com.maruchin.gymster.data.trainings.json.SettingRequestJson
import com.maruchin.gymster.data.trainings.model.AddSetRequest

internal fun AddSetRequest.toJson() = SettingRequestJson(
    set = exerciseId,
    exerciseBase = exerciseBaseId,
    reps = 0
)
