package com.maruchin.gymster.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.maruchin.gymster.core.database.entity.TrainingEntity
import com.maruchin.gymster.core.database.relation.TrainingWithExercises
import kotlinx.coroutines.flow.Flow

@Dao
interface TrainingDao {

    @Transaction
    @Query("SELECT * FROM TrainingEntity WHERE id = :trainingId")
    fun observeTraining(trainingId: String): Flow<TrainingWithExercises?>

    @Insert
    suspend fun insert(trainings: List<TrainingEntity>)
}
