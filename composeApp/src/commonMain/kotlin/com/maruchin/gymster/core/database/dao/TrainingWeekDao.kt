package com.maruchin.gymster.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.maruchin.gymster.core.database.entity.TrainingWeekEntity
import com.maruchin.gymster.core.database.relation.TrainingWeekWithTrainings
import kotlinx.coroutines.flow.Flow

@Dao
interface TrainingWeekDao {

    @Transaction
    @Query("SELECT * FROM TrainingWeekEntity")
    fun observeAllTrainings(): Flow<List<TrainingWeekWithTrainings>>

    @Transaction
    @Query("SELECT * FROM TrainingWeekEntity ORDER BY startDate DESC LIMIT 1")
    fun observeCurrentTrainingWeek(): Flow<TrainingWeekWithTrainings?>

    @Query("SELECT * FROM TrainingWeekEntity ORDER BY startDate DESC LIMIT 1")
    suspend fun getCurrentTrainingWeek(): TrainingWeekEntity?

    @Insert
    suspend fun insert(trainingWeek: TrainingWeekEntity)

    @Update
    suspend fun update(trainingWeek: TrainingWeekEntity)
}
