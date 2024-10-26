package com.maruchin.gymster.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.LocalDate

@Entity
internal data class TrainingWeekEntity(@PrimaryKey val id: String, val startDate: LocalDate)
