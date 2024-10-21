package com.maruchin.gymster.core.database.dao

import com.maruchin.gymster.core.database.entity.TrainingEntity
import com.maruchin.gymster.core.database.relation.ExerciseWithSetResults
import com.maruchin.gymster.core.database.relation.TrainingWithExercises
import com.maruchin.gymster.core.database.room.FakeGymsterDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update

class FakeTrainingDao internal constructor(private val database: FakeGymsterDatabase) :
    TrainingDao {

    override fun observeTraining(trainingId: String): Flow<TrainingWithExercises?> = combine(
        database.trainings,
        database.exercises,
        database.setResults
    ) { trainings, exercises, setResults ->
        trainings[trainingId]?.let { training ->
            TrainingWithExercises(
                training = training,
                exercises = exercises.values.filter { it.trainingId == trainingId }
                    .map { exercise ->
                        ExerciseWithSetResults(
                            exercise = exercise,
                            setResults = setResults.values.filter { it.exerciseId == exercise.id }
                        )
                    }
            )
        }
    }

    override suspend fun getTraining(trainingId: String): TrainingEntity? {
        TODO("Not yet implemented")
    }

    override suspend fun insert(trainings: List<TrainingEntity>) {
        database.trainings.update { map ->
            map + trainings.associateBy { it.id }
        }
    }

    override suspend fun update(training: TrainingEntity) {
        TODO("Not yet implemented")
    }
}
