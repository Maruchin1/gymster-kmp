package com.maruchin.gymster.data.plans.datasource

import com.maruchin.gymster.core.database.dao.PlanDao
import com.maruchin.gymster.core.database.dao.PlanExerciseDao
import com.maruchin.gymster.core.database.dao.PlanTrainingDao
import com.maruchin.gymster.core.database.entity.PlanEntity
import com.maruchin.gymster.core.database.entity.PlanExerciseEntity
import com.maruchin.gymster.core.database.entity.PlanTrainingEntity
import com.maruchin.gymster.core.database.relation.PlanWithTrainings
import kotlin.uuid.Uuid
import kotlinx.coroutines.flow.Flow

internal class PlansLocalDataSource(
    private val planDao: PlanDao,
    private val planTrainingDao: PlanTrainingDao,
    private val planExerciseDao: PlanExerciseDao
) {

    fun observeAllPlans(): Flow<List<PlanWithTrainings>> = planDao.observeAllPlansWithTrainings()

    fun observePlan(planId: String): Flow<PlanWithTrainings?> =
        planDao.observePlanWithTrainings(planId)

    suspend fun createPlan(name: String): String {
        val plan = PlanEntity(
            id = Uuid.random().toString(),
            name = name
        )
        planDao.insertPlan(plan)
        return plan.id
    }

    suspend fun updatePlan(planId: String, name: String) {
        val plan = planDao.getPlan(planId)
        checkNotNull(plan)
        val updatedPlan = plan.copy(name = name)
        planDao.updatePlan(updatedPlan)
    }

    suspend fun deletePlan(planId: String) {
        val plan = planDao.getPlan(planId)
        checkNotNull(plan)
        planDao.deletePlan(plan)
    }

    suspend fun addTraining(planId: String, name: String): String {
        val training = PlanTrainingEntity(
            id = Uuid.random().toString(),
            planId = planId,
            name = name
        )
        planTrainingDao.insertPlanTraining(training)
        return training.id
    }

    suspend fun updateTraining(trainingId: String, name: String) {
        val training = planTrainingDao.getPlanTraining(trainingId)
        checkNotNull(training)
        val updateTraining = training.copy(name = name)
        planTrainingDao.updatePlanTraining(updateTraining)
    }

    suspend fun deleteTraining(trainingId: String) {
        val training = planTrainingDao.getPlanTraining(trainingId)
        checkNotNull(training)
        planTrainingDao.deletePlanTraining(training)
    }

    suspend fun addExercise(trainingId: String, name: String, sets: Int, reps: IntRange): String {
        val exercisesCount = planExerciseDao.countPlanExercisesForTraining(trainingId)
        val exercise = PlanExerciseEntity(
            id = Uuid.random().toString(),
            trainingId = trainingId,
            index = exercisesCount,
            name = name,
            sets = sets,
            minReps = reps.first,
            maxReps = reps.last
        )
        planExerciseDao.insertPlanExercise(exercise)
        return exercise.id
    }

    suspend fun updateExercise(exerciseId: String, name: String, sets: Int, reps: IntRange) {
        val exercise = planExerciseDao.getPlanExercise(exerciseId)
        checkNotNull(exercise)
        val updatedExercise = exercise.copy(
            name = name,
            sets = sets,
            minReps = reps.first,
            maxReps = reps.last
        )
        planExerciseDao.updatePlanExercise(updatedExercise)
    }

    suspend fun deleteExercise(exerciseId: String) {
        val exercise = planExerciseDao.getPlanExercise(exerciseId)
        checkNotNull(exercise)
        planExerciseDao.deletePlanExercise(exercise)
    }

    suspend fun reorderExercises(exercisesIds: List<String>) {
        exercisesIds.forEachIndexed { index, exerciseId ->
            val exercise = planExerciseDao.getPlanExercise(exerciseId)
            checkNotNull(exercise)
            val updatedExercise = exercise.copy(index = index)
            planExerciseDao.updatePlanExercise(updatedExercise)
        }
    }
}
