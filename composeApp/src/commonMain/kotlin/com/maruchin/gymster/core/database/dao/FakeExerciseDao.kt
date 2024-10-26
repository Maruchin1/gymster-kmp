package com.maruchin.gymster.core.database.dao

import com.maruchin.gymster.core.database.entity.ExerciseEntity
import com.maruchin.gymster.core.database.FakeGymsterDatabase
import kotlinx.coroutines.flow.update

class FakeExerciseDao internal constructor(private val database: FakeGymsterDatabase) :
    ExerciseDao {

    override suspend fun insert(exercises: List<ExerciseEntity>) {
        database.exercises.update { map ->
            map + exercises.associateBy { it.id }
        }
    }
}
