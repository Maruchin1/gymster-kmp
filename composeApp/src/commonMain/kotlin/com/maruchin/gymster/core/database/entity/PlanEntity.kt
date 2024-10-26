package com.maruchin.gymster.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
internal data class PlanEntity(@PrimaryKey val id: String, val name: String)
