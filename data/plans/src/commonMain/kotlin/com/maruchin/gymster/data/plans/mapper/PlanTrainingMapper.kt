package com.maruchin.gymster.data.plans.mapper

import com.maruchin.gymster.core.database.relation.PlanTrainingWithExercises
import com.maruchin.gymster.data.plans.model.PlanTraining

internal fun PlanTrainingWithExercises.toDomainModel() = PlanTraining(
    id = training.id,
    name = training.name,
    exercises = exercises.sortedBy { it.index }.map { it.toDomainModel() }
)
