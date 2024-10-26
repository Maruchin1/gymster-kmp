package com.maruchin.gymster.core.database.fakedao

import com.maruchin.gymster.core.database.FakeGymsterDatabase
import com.maruchin.gymster.core.database.dao.ExerciseDao
import com.maruchin.gymster.core.database.entity.ExerciseEntity
import kotlinx.coroutines.flow.update

internal class FakeExerciseDao internal constructor(private val database: FakeGymsterDatabase) :
    ExerciseDao {

    override suspend fun insert(exercises: List<ExerciseEntity>) {
        database.exercises.update { map ->
            map + exercises.associateBy { it.id }
        }
    }
}
