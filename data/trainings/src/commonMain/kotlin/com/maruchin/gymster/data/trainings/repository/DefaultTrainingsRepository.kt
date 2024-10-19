package com.maruchin.gymster.data.trainings.repository

import com.maruchin.gymster.core.database.dao.ExerciseDao
import com.maruchin.gymster.core.database.dao.SetResultDao
import com.maruchin.gymster.core.database.dao.TrainingDao
import com.maruchin.gymster.core.database.dao.TrainingWeekDao
import com.maruchin.gymster.core.utils.clock.currentDate
import com.maruchin.gymster.data.plans.model.Plan
import com.maruchin.gymster.data.trainings.mapper.toDbModel
import com.maruchin.gymster.data.trainings.mapper.toDomainModel
import com.maruchin.gymster.data.trainings.model.Training
import com.maruchin.gymster.data.trainings.model.TrainingWeek
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.datetime.Clock

internal class DefaultTrainingsRepository(
    private val trainingWeekDao: TrainingWeekDao,
    private val trainingDao: TrainingDao,
    private val exerciseDao: ExerciseDao,
    private val setResulDao: SetResultDao,
    private val clock: Clock
) : TrainingsRepository {

    override fun observeAllTrainingWeeks(): Flow<List<TrainingWeek>> =
        trainingWeekDao.observeAllTrainings().map { list ->
            list.map { it.toDomainModel() }
        }

    override fun observeCurrentTrainingWeek(): Flow<TrainingWeek?> =
        trainingWeekDao.observeCurrentTrainingWeek().map { it?.toDomainModel() }

    override fun observeTraining(trainingId: String): Flow<Training?> =
        trainingDao.observeTraining(trainingId).map { it?.toDomainModel() }

    override suspend fun startNewWeek(plan: Plan): TrainingWeek {
        val currentDate = clock.currentDate()
        val trainingWeek = TrainingWeek.from(plan, currentDate)
        val trainingWeekWithTrainings = trainingWeek.toDbModel()
        val trainingEntities = trainingWeekWithTrainings.trainings.map { it.training }
        val exerciseEntities = trainingWeekWithTrainings.trainings
            .flatMap { it.exercises }
            .map { it.exercise }
        val setResultEntities = trainingWeekWithTrainings.trainings
            .flatMap { it.exercises }
            .flatMap { it.setResults }

        trainingWeekDao.insert(trainingWeekWithTrainings.trainingWeek)
        trainingDao.insert(trainingEntities)
        exerciseDao.insert(exerciseEntities)
        setResulDao.insert(setResultEntities)

        return trainingWeek
    }

    override suspend fun updateSetResult(setResultId: String, weight: Double, reps: Int) {
        val setResult = setResulDao.getSetResult(setResultId)
        checkNotNull(setResult)
        val updatedSetResult = setResult.copy(weight = weight, reps = reps)
        setResulDao.update(updatedSetResult)
    }
}
