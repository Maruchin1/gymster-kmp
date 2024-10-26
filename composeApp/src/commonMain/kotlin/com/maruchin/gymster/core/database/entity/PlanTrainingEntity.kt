package com.maruchin.gymster.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
internal data class PlanTrainingEntity(
    @PrimaryKey val id: String,
    val planId: String,
    val name: String
)
