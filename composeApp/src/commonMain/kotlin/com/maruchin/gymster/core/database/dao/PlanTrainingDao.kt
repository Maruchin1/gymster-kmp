package com.maruchin.gymster.core.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.maruchin.gymster.core.database.entity.PlanTrainingEntity

@Dao
internal interface PlanTrainingDao {

    @Query("SELECT * FROM PlanTrainingEntity WHERE id = :trainingId")
    suspend fun getPlanTraining(trainingId: String): PlanTrainingEntity?

    @Insert
    suspend fun insertPlanTraining(planTraining: PlanTrainingEntity)

    @Update
    suspend fun updatePlanTraining(planTraining: PlanTrainingEntity)

    @Delete
    suspend fun deletePlanTraining(planTraining: PlanTrainingEntity)
}
