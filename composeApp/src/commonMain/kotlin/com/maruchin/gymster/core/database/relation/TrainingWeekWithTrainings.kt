package com.maruchin.gymster.core.database.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.maruchin.gymster.core.database.entity.TrainingEntity
import com.maruchin.gymster.core.database.entity.TrainingWeekEntity

internal data class TrainingWeekWithTrainings(
    @Embedded
    val trainingWeek: TrainingWeekEntity,
    @Relation(parentColumn = "id", entityColumn = "trainingWeekId", entity = TrainingEntity::class)
    val trainings: List<TrainingWithExercises>
)
