package com.maruchin.gymster.data.trainings.mapper

import com.maruchin.gymster.core.database.entity.TrainingWeekEntity
import com.maruchin.gymster.core.database.relation.TrainingWeekWithTrainings
import com.maruchin.gymster.data.trainings.model.TrainingWeek

internal fun TrainingWeekWithTrainings.toDomainModel() = TrainingWeek(
    id = trainingWeek.id,
    trainings = trainings.map { it.toDomainModel() }
)

internal fun TrainingWeek.toDbModel() = TrainingWeekWithTrainings(
    trainingWeek = TrainingWeekEntity(id = id),
    trainings = trainings.map { it.toDbModel(id) }
)
