package com.maruchin.gymster.data.trainings.mapper

import com.maruchin.gymster.data.trainings.json.DayJson
import com.maruchin.gymster.data.trainings.model.Exercise
import com.maruchin.gymster.data.trainings.model.Training

internal fun DayJson.toDomain(exercises: List<Exercise>) = Training(
    id = id,
    name = description,
    exercises = exercises
)
