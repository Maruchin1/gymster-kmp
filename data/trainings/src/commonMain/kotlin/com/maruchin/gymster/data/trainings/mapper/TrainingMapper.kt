package com.maruchin.gymster.data.trainings.mapper

import com.maruchin.gymster.core.database.entity.TrainingEntity
import com.maruchin.gymster.core.database.relation.TrainingWithExercises
import com.maruchin.gymster.data.trainings.model.Training

internal fun TrainingWithExercises.toDomainModel() = Training(
    id = training.id,
    name = training.name,
    date = training.date,
    exercises = exercises.map { it.toDomainModel() }
)

internal fun Training.toDbModel(trainingWeekId: String) = TrainingWithExercises(
    training = TrainingEntity(
        id = id,
        trainingWeekId = trainingWeekId,
        name = name,
        date = date
    ),
    exercises = exercises.map { it.toDbModel(id) }
)
