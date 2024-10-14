package com.maruchin.gymster.core.database.room

import com.maruchin.gymster.core.database.entity.PlanEntity
import com.maruchin.gymster.core.database.entity.PlanExerciseEntity
import com.maruchin.gymster.core.database.entity.PlanTrainingEntity
import kotlinx.coroutines.flow.MutableStateFlow

class FakeGymsterDatabase {
    val plans = MutableStateFlow(emptyMap<String, PlanEntity>())
    val planTrainings = MutableStateFlow(emptyMap<String, PlanTrainingEntity>())
    val planExercises = MutableStateFlow(emptyMap<String, PlanExerciseEntity>())
}
