package com.maruchin.gymster.core.database

import com.maruchin.gymster.core.database.entity.ExerciseEntity
import com.maruchin.gymster.core.database.entity.PlanEntity
import com.maruchin.gymster.core.database.entity.PlanExerciseEntity
import com.maruchin.gymster.core.database.entity.PlanTrainingEntity
import com.maruchin.gymster.core.database.entity.SetResultEntity
import com.maruchin.gymster.core.database.entity.TrainingEntity
import com.maruchin.gymster.core.database.entity.TrainingWeekEntity
import kotlinx.coroutines.flow.MutableStateFlow

internal class FakeGymsterDatabase {
    val plans = MutableStateFlow(emptyMap<String, PlanEntity>())
    val planTrainings = MutableStateFlow(emptyMap<String, PlanTrainingEntity>())
    val planExercises = MutableStateFlow(emptyMap<String, PlanExerciseEntity>())
    val trainingWeeks = MutableStateFlow(emptyMap<String, TrainingWeekEntity>())
    val trainings = MutableStateFlow(emptyMap<String, TrainingEntity>())
    val exercises = MutableStateFlow(emptyMap<String, ExerciseEntity>())
    val setResults = MutableStateFlow(emptyMap<String, SetResultEntity>())
}