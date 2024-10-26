package com.maruchin.gymster.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PlanExerciseEntity(
    @PrimaryKey val id: String,
    val trainingId: String,
    val index: Int,
    val name: String,
    val sets: Int,
    val minReps: Int,
    val maxReps: Int
)
