package com.maruchin.gymster.data.trainings.mapper

import com.maruchin.gymster.core.database.entity.SetResultEntity
import com.maruchin.gymster.data.trainings.model.SetResult

internal fun SetResultEntity.toDomainModel() = SetResult(
    id = id,
    weight = weight,
    reps = reps
)

internal fun SetResult.toDbModel(exerciseId: String) = SetResultEntity(
    id = id,
    exerciseId = exerciseId,
    weight = weight,
    reps = reps
)
