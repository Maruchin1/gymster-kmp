package com.maruchin.gymster.core.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.maruchin.gymster.core.database.entity.PlanEntity
import com.maruchin.gymster.core.database.relation.PlanWithTrainings
import kotlinx.coroutines.flow.Flow

@Dao
interface PlanDao {

    @Transaction
    @Query("SELECT * FROM PlanEntity")
    fun observeAllPlansWithTrainings(): Flow<List<PlanWithTrainings>>

    @Transaction
    @Query("SELECT * FROM PlanEntity WHERE id = :planId")
    fun observePlanWithTrainings(planId: String): Flow<PlanWithTrainings?>

    @Query("SELECT * FROM PlanEntity WHERE id = :id")
    suspend fun getPlan(id: String): PlanEntity?

    @Insert
    suspend fun insertPlan(plan: PlanEntity)

    @Update
    suspend fun updatePlan(plan: PlanEntity)

    @Delete
    suspend fun deletePlan(plan: PlanEntity)
}
