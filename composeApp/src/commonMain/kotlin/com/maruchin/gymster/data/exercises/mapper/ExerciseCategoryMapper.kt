package com.maruchin.gymster.data.exercises.mapper

import com.maruchin.gymster.data.exercises.json.ExerciseCategoryJson
import com.maruchin.gymster.data.exercises.model.ExerciseCategory

internal fun ExerciseCategoryJson.toDomain() = ExerciseCategory(
    id = id,
    name = name
)
