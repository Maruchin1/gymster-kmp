package com.maruchin.gymster.core.database.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.maruchin.gymster.core.database.entity.ExerciseEntity
import com.maruchin.gymster.core.database.entity.TrainingEntity

internal data class TrainingWithExercises(
    @Embedded
    val training: TrainingEntity,
    @Relation(parentColumn = "id", entityColumn = "trainingId", entity = ExerciseEntity::class)
    val exercises: List<ExerciseWithSetResults>
)
