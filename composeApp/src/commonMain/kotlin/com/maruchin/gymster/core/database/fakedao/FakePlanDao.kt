package com.maruchin.gymster.core.database.fakedao

import com.maruchin.gymster.core.database.FakeGymsterDatabase
import com.maruchin.gymster.core.database.dao.PlanDao
import com.maruchin.gymster.core.database.entity.PlanEntity
import com.maruchin.gymster.core.database.relation.PlanTrainingWithExercises
import com.maruchin.gymster.core.database.relation.PlanWithTrainings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update

internal class FakePlanDao internal constructor(private val database: FakeGymsterDatabase) :
    PlanDao {

    override fun observeAllPlansWithTrainings(): Flow<List<PlanWithTrainings>> = combine(
        database.plans,
        database.planTrainings,
        database.planExercises
    ) { plans, trainings, exercises ->
        plans.values.map { plan ->
            PlanWithTrainings(
                plan = plan,
                trainings = trainings.values.filter { it.planId == plan.id }
                    .map { matchingTraining ->
                        PlanTrainingWithExercises(
                            training = matchingTraining,
                            exercises = exercises.values.filter {
                                it.trainingId == matchingTraining.id
                            }
                        )
                    }
            )
        }
    }

    override fun observePlanWithTrainings(planId: String): Flow<PlanWithTrainings?> = combine(
        database.plans,
        database.planTrainings,
        database.planExercises
    ) { plans, trainings, exercises ->
        plans[planId]?.let { plan ->
            PlanWithTrainings(
                plan = plan,
                trainings = trainings.values.filter { it.planId == plan.id }
                    .map { matchingTraining ->
                        PlanTrainingWithExercises(
                            training = matchingTraining,
                            exercises = exercises.values.filter {
                                it.trainingId == matchingTraining.id
                            }
                        )
                    }
            )
        }
    }

    override suspend fun getPlan(id: String): PlanEntity? {
        val plans = database.plans.value
        return plans[id]
    }

    override suspend fun insertPlan(plan: PlanEntity) {
        database.plans.update { plans ->
            plans + (plan.id to plan)
        }
    }

    override suspend fun updatePlan(plan: PlanEntity) {
        database.plans.update { plans ->
            plans + (plan.id to plan)
        }
    }

    override suspend fun deletePlan(plan: PlanEntity) {
        database.plans.update { plans ->
            plans - plan.id
        }
    }
}
