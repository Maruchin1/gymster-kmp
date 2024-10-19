package com.maruchin.gymster.data.trainings.repository

import com.maruchin.gymster.data.plans.model.Plan
import com.maruchin.gymster.data.trainings.model.Training
import com.maruchin.gymster.data.trainings.model.TrainingWeek
import kotlinx.coroutines.flow.Flow

interface TrainingsRepository {

    fun observeAllTrainings(): Flow<List<TrainingWeek>>

    fun observeTraining(trainingId: String): Flow<Training?>

    suspend fun startNewWeek(plan: Plan): TrainingWeek

    suspend fun updateSetResult(setResultId: String, weight: Double, reps: Int)
}
