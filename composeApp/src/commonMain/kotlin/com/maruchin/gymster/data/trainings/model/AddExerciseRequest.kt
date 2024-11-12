package com.maruchin.gymster.data.trainings.model

internal data class AddExerciseRequest(
    val trainingId: Int,
    val exerciseBaseId: Int,
    val sets: Int,
    val reps: Int
)
