package com.maruchin.gymster.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
internal data class ExerciseEntity(
    @PrimaryKey val id: String,
    val trainingId: String,
    val name: String,
    val sets: Int,
    val minReps: Int,
    val maxReps: Int
)
