package com.maruchin.gymster.data.exercises.json

import kotlinx.serialization.Serializable

@Serializable
internal data class ExerciseTranslationBaseInfoJson(
    val id: Int,
    val uuid: String,
    val name: String,
    val description: String,
    val language: Int
)
