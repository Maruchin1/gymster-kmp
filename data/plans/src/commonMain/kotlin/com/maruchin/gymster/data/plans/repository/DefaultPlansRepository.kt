package com.maruchin.gymster.data.plans.repository

import com.maruchin.gymster.data.plans.datasource.PlansLocalDataSource
import com.maruchin.gymster.data.plans.datasource.PlansPreferencesDataSource
import com.maruchin.gymster.data.plans.mapper.toDomainModel
import com.maruchin.gymster.data.plans.model.Plan
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

@OptIn(ExperimentalCoroutinesApi::class)
internal class DefaultPlansRepository(
    private val plansLocalDataSource: PlansLocalDataSource,
    private val plansPreferencesDataSource: PlansPreferencesDataSource
) : PlansRepository {

    override fun observeAllPlans(): Flow<List<Plan>> =
        plansLocalDataSource.observeAllPlans().map { list ->
            list.map { it.toDomainModel() }
        }

    override fun observePlan(planId: String): Flow<Plan?> =
        plansLocalDataSource.observePlan(planId).map {
            it?.toDomainModel()
        }

    override fun observeActivePlan(): Flow<Plan?> = plansPreferencesDataSource.observeActivePlanId()
        .flatMapLatest {
            if (it == null) return@flatMapLatest flowOf(null)
            plansLocalDataSource.observePlan(it)
        }
        .map { it?.toDomainModel() }

    override suspend fun createPlan(name: String): String = plansLocalDataSource.createPlan(name)

    override suspend fun updatePlan(planId: String, name: String) {
        plansLocalDataSource.updatePlan(planId, name)
    }

    override suspend fun deletePlan(planId: String) {
        plansLocalDataSource.deletePlan(planId)
    }

    override suspend fun addTraining(planId: String, name: String): String =
        plansLocalDataSource.addTraining(planId, name)

    override suspend fun updateTraining(trainingId: String, name: String) {
        plansLocalDataSource.updateTraining(trainingId, name)
    }

    override suspend fun deleteTraining(trainingId: String) {
        plansLocalDataSource.deleteTraining(trainingId)
    }

    override suspend fun addExercise(
        trainingId: String,
        name: String,
        sets: Int,
        reps: IntRange
    ): String = plansLocalDataSource.addExercise(trainingId, name, sets, reps)

    override suspend fun updateExercise(
        exerciseId: String,
        name: String,
        sets: Int,
        reps: IntRange
    ) {
        plansLocalDataSource.updateExercise(exerciseId, name, sets, reps)
    }

    override suspend fun deleteExercise(exerciseId: String) {
        plansLocalDataSource.deleteExercise(exerciseId)
    }

    override suspend fun reorderExercises(exercisesIds: List<String>) {
        plansLocalDataSource.reorderExercises(exercisesIds)
    }

    override suspend fun setActivePlan(planId: String) {
        plansPreferencesDataSource.setActivePlanId(planId)
    }
}
