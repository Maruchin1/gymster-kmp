package com.maruchin.gymster.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.LocalDate

@Entity
internal data class TrainingEntity(
    @PrimaryKey val id: String,
    val trainingWeekId: String,
    val name: String,
    val date: LocalDate?
)
