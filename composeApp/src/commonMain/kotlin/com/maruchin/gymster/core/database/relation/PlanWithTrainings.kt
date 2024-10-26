package com.maruchin.gymster.core.database.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.maruchin.gymster.core.database.entity.PlanEntity
import com.maruchin.gymster.core.database.entity.PlanTrainingEntity

internal data class PlanWithTrainings(
    @Embedded
    val plan: PlanEntity,
    @Relation(entity = PlanTrainingEntity::class, parentColumn = "id", entityColumn = "planId")
    val trainings: List<PlanTrainingWithExercises>
)
