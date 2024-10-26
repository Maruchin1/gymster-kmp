package com.maruchin.gymster.data.trainings.mapper

import com.maruchin.gymster.core.database.entity.ExerciseEntity
import com.maruchin.gymster.core.database.relation.ExerciseWithSetResults
import com.maruchin.gymster.data.trainings.model.Exercise

internal fun ExerciseWithSetResults.toDomainModel() = Exercise(
    id = exercise.id,
    name = exercise.name,
    sets = exercise.sets,
    reps = exercise.minReps..exercise.maxReps,
    setsResults = setResults.map { it.toDomainModel() }
)

internal fun Exercise.toDbModel(trainingId: String) = ExerciseWithSetResults(
    exercise = ExerciseEntity(
        id = id,
        trainingId = trainingId,
        name = name,
        sets = sets,
        minReps = reps.first,
        maxReps = reps.last
    ),
    setResults = setsResults.map { it.toDbModel(id) }
)
