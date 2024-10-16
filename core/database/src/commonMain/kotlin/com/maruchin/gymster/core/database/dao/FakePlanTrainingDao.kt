package com.maruchin.gymster.core.database.dao

import com.maruchin.gymster.core.database.entity.PlanTrainingEntity
import com.maruchin.gymster.core.database.room.FakeGymsterDatabase
import kotlinx.coroutines.flow.update

class FakePlanTrainingDao internal constructor(private val database: FakeGymsterDatabase) :
    PlanTrainingDao {

    override suspend fun getPlanTraining(trainingId: String): PlanTrainingEntity? =
        database.planTrainings.value[trainingId]

    override suspend fun insertPlanTraining(planTraining: PlanTrainingEntity) {
        database.planTrainings.update { trainings ->
            trainings + (planTraining.id to planTraining)
        }
    }

    override suspend fun updatePlanTraining(planTraining: PlanTrainingEntity) {
        database.planTrainings.update { trainings ->
            trainings + (planTraining.id to planTraining)
        }
    }

    override suspend fun deletePlanTraining(planTraining: PlanTrainingEntity) {
        database.planTrainings.update { trainings ->
            trainings - planTraining.id
        }
    }
}
