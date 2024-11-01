package com.maruchin.gymster.data.exercises.json

import kotlinx.serialization.Serializable

@Serializable
internal data class ExerciseImageJson(val id: Int, val uuid: String, val image: String)
