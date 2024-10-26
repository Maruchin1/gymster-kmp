package com.maruchin.gymster.data.plans.mapper

import com.maruchin.gymster.core.database.entity.PlanExerciseEntity
import com.maruchin.gymster.data.plans.model.PlanExercise

internal fun PlanExerciseEntity.toDomainModel() = PlanExercise(
    id = id,
    name = name,
    sets = sets,
    reps = minReps..maxReps
)
