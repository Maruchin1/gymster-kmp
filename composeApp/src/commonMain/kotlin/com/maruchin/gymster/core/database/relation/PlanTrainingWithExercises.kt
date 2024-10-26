package com.maruchin.gymster.core.database.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.maruchin.gymster.core.database.entity.PlanExerciseEntity
import com.maruchin.gymster.core.database.entity.PlanTrainingEntity

data class PlanTrainingWithExercises(
    @Embedded
    val training: PlanTrainingEntity,
    @Relation(parentColumn = "id", entityColumn = "trainingId")
    val exercises: List<PlanExerciseEntity>
)
