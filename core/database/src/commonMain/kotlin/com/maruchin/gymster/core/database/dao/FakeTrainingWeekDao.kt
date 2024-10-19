package com.maruchin.gymster.core.database.dao

import com.maruchin.gymster.core.database.entity.TrainingWeekEntity
import com.maruchin.gymster.core.database.relation.ExerciseWithSetResults
import com.maruchin.gymster.core.database.relation.TrainingWeekWithTrainings
import com.maruchin.gymster.core.database.relation.TrainingWithExercises
import com.maruchin.gymster.core.database.room.FakeGymsterDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update

class FakeTrainingWeekDao internal constructor(private val database: FakeGymsterDatabase) :
    TrainingWeekDao {

    override fun observeAllTrainings(): Flow<List<TrainingWeekWithTrainings>> = combine(
        database.trainingWeeks,
        database.trainings,
        database.exercises,
        database.setResults
    ) { trainingWeeks, trainings, exercises, setResults ->
        trainingWeeks.values.map { trainingWeek ->
            TrainingWeekWithTrainings(
                trainingWeek = trainingWeek,
                trainings = trainings.values.filter { it.trainingWeekId == trainingWeek.id }
                    .map { training ->
                        TrainingWithExercises(
                            training = training,
                            exercises = exercises.values.filter { it.trainingId == training.id }
                                .map { exercise ->
                                    ExerciseWithSetResults(
                                        exercise = exercise,
                                        setResults = setResults.values.filter {
                                            it.exerciseId == exercise.id
                                        }
                                    )
                                }
                        )
                    }
            )
        }
    }

    override suspend fun insert(trainingWeek: TrainingWeekEntity) {
        database.trainingWeeks.update {
            it + (trainingWeek.id to trainingWeek)
        }
    }
}
