package com.maruchin.gymster.data.trainings.mapper

import com.maruchin.gymster.data.trainings.json.SettingJson
import com.maruchin.gymster.data.trainings.model.ExerciseSet

internal fun SettingJson.toDomain() = ExerciseSet(
    id = id,
    reps = reps,
    weight = weight
)
