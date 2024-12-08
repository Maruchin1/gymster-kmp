package com.maruchin.gymster.data.plans2.mapper

import com.maruchin.gymster.data.plans2.json.SettingJson
import com.maruchin.gymster.data.plans2.model.SetTemplate

internal fun SettingJson.toDomain() = SetTemplate(
    id = id,
    weight = weight,
    reps = reps
)
