package com.maruchin.gymster.data.trainings.repository

import com.maruchin.gymster.core.utils.clock.currentDate
import com.maruchin.gymster.data.plans.model.Plan
import com.maruchin.gymster.data.trainings.model.Training
import com.maruchin.gymster.data.trainings.model.TrainingWeek
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.datetime.Clock

class FakeTrainingsRepository(private val clock: Clock) : TrainingsRepository {

    private val trainingWeeks = MutableStateFlow(emptyList<TrainingWeek>())

    fun setTrainingWeeks(weeks: List<TrainingWeek>) {
        trainingWeeks.value = weeks
    }

    override fun observeAllTrainings(): Flow<List<TrainingWeek>> = trainingWeeks

    override fun observeCurrentTrainingWeek(): Flow<TrainingWeek?> = trainingWeeks.map { weeks ->
        weeks.maxByOrNull { it.startDate }
    }

    override fun observeTraining(trainingId: String): Flow<Training?> = trainingWeeks.map { weeks ->
        weeks.flatMap { it.trainings }.find { it.id == trainingId }
    }

    override suspend fun startNewWeek(plan: Plan): TrainingWeek {
        val currentDate = clock.currentDate()
        val trainingWeek = TrainingWeek.from(plan, currentDate)
        trainingWeeks.update { weeks ->
            weeks + trainingWeek
        }
        return trainingWeek
    }

    override suspend fun updateSetResult(setResultId: String, weight: Double, reps: Int) {
        TODO("Not yet implemented")
    }
}
