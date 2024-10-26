package com.maruchin.gymster.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
internal data class SetResultEntity(
    @PrimaryKey val id: String,
    val exerciseId: String,
    val weight: Double?,
    val reps: Int?
)
