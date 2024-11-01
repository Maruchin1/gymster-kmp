package com.maruchin.gymster.data.exercises.json

import kotlinx.serialization.Serializable

@Serializable
internal data class PaginatedExerciseBaseInfoListJson(val results: List<ExerciseBaseInfoJson>)
