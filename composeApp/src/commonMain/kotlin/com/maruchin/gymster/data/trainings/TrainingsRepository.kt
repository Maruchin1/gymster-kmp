package com.maruchin.gymster.data.trainings

import com.maruchin.gymster.data.plans.model.Plan
import com.maruchin.gymster.data.trainings.model.Training
import com.maruchin.gymster.data.trainings.model.TrainingWeek
import kotlinx.coroutines.flow.Flow
import kotlinx.datetime.LocalDate

interface TrainingsRepository {

    fun observeAllTrainingWeeks(): Flow<List<TrainingWeek>>

    fun observeCurrentTrainingWeek(): Flow<TrainingWeek?>

    fun observeTraining(trainingId: String): Flow<Training?>

    suspend fun startNewWeek(plan: Plan): TrainingWeek

    suspend fun updateTraining(trainingId: String, date: LocalDate)

    suspend fun updateSetResult(setResultId: String, weight: Double, reps: Int)

    suspend fun completeTraining(trainingId: String)
}
