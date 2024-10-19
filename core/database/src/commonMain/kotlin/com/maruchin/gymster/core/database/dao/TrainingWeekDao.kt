package com.maruchin.gymster.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.maruchin.gymster.core.database.entity.TrainingWeekEntity
import com.maruchin.gymster.core.database.relation.TrainingWeekWithTrainings
import kotlinx.coroutines.flow.Flow

@Dao
interface TrainingWeekDao {

    @Transaction
    @Query("SELECT * FROM TrainingWeekEntity")
    fun observeAllTrainings(): Flow<List<TrainingWeekWithTrainings>>

    @Insert
    suspend fun insert(trainingWeek: TrainingWeekEntity)
}
