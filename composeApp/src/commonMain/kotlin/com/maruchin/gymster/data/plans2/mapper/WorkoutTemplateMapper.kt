package com.maruchin.gymster.data.plans2.mapper

import com.maruchin.gymster.data.plans2.json.DayJson
import com.maruchin.gymster.data.plans2.model.ExerciseTemplate
import com.maruchin.gymster.data.plans2.model.WorkoutTemplate

internal fun DayJson.toDomain(exercises: List<ExerciseTemplate>) = WorkoutTemplate(
    id = id,
    name = description,
    exercises = exercises
)
