package com.maruchin.gymster.data.exercises.mapper

import com.maruchin.gymster.data.exercises.json.ExerciseBaseInfoJson
import com.maruchin.gymster.data.exercises.model.ExerciseBase

private const val EnglishLanguage = 2

internal fun ExerciseBaseInfoJson.toDomain() = ExerciseBase(
    id = id,
    name = exercises.find { it.language == EnglishLanguage }?.name.orEmpty(),
    description = exercises.find { it.language == EnglishLanguage }?.description.orEmpty(),
    category = category.toDomain(),
    images = images.map { it.image }
)
