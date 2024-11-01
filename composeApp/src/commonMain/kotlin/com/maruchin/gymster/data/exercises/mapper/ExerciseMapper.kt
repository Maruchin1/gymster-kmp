package com.maruchin.gymster.data.exercises.mapper

import com.maruchin.gymster.data.exercises.json.ExerciseBaseInfoJson
import com.maruchin.gymster.data.exercises.model.Exercise

private const val ENGLISH_LANGUAGE = 2

internal fun ExerciseBaseInfoJson.toDomain() = Exercise(
    id = id,
    name = exercises.find { it.language == ENGLISH_LANGUAGE }?.name.orEmpty(),
    description = exercises.find { it.language == ENGLISH_LANGUAGE }?.description.orEmpty(),
    category = category.toDomain(),
    images = images.map { it.image }
)
