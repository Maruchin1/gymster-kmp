package com.maruchin.gymster.core.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.maruchin.gymster.core.database.entity.PlanExerciseEntity

@Dao
interface PlanExerciseDao {

    @Query("SELECT * FROM PlanExerciseEntity WHERE id = :exerciseId")
    suspend fun getPlanExercise(exerciseId: String): PlanExerciseEntity?

    @Query("SELECT COUNT(*) FROM PlanExerciseEntity WHERE trainingId = :trainingId")
    suspend fun countPlanExercisesForTraining(trainingId: String): Int

    @Insert
    suspend fun insertPlanExercise(exercise: PlanExerciseEntity)

    @Update
    suspend fun updatePlanExercise(exercise: PlanExerciseEntity)

    @Delete
    suspend fun deletePlanExercise(exercise: PlanExerciseEntity)
}
