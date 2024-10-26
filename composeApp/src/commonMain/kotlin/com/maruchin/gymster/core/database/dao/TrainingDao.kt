package com.maruchin.gymster.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.maruchin.gymster.core.database.entity.TrainingEntity
import com.maruchin.gymster.core.database.relation.TrainingWithExercises
import kotlinx.coroutines.flow.Flow

@Dao
internal interface TrainingDao {

    @Transaction
    @Query("SELECT * FROM TrainingEntity WHERE id = :trainingId")
    fun observeTraining(trainingId: String): Flow<TrainingWithExercises?>

    @Query("SELECT * FROM TrainingEntity WHERE id = :trainingId")
    suspend fun getTraining(trainingId: String): TrainingEntity?

    @Insert
    suspend fun insert(trainings: List<TrainingEntity>)

    @Update
    suspend fun update(training: TrainingEntity)
}
