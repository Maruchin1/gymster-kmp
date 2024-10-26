package com.maruchin.gymster.core.database.dao

import com.maruchin.gymster.core.database.entity.PlanExerciseEntity
import com.maruchin.gymster.core.database.FakeGymsterDatabase
import kotlinx.coroutines.flow.update

class FakePlanExerciseDao internal constructor(private val database: FakeGymsterDatabase) :
    PlanExerciseDao {

    override suspend fun getPlanExercise(exerciseId: String): PlanExerciseEntity? =
        database.planExercises.value[exerciseId]

    override suspend fun countPlanExercisesForTraining(trainingId: String): Int =
        database.planExercises.value.count { (_, exercise) -> exercise.trainingId == trainingId }

    override suspend fun insertPlanExercise(exercise: PlanExerciseEntity) {
        database.planExercises.update { exercises ->
            exercises + (exercise.id to exercise)
        }
    }

    override suspend fun updatePlanExercise(exercise: PlanExerciseEntity) {
        database.planExercises.update { exercises ->
            exercises + (exercise.id to exercise)
        }
    }

    override suspend fun deletePlanExercise(exercise: PlanExerciseEntity) {
        database.planExercises.update { exercises ->
            exercises - exercise.id
        }
    }
}
