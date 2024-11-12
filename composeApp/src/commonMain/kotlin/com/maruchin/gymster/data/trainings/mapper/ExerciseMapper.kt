package com.maruchin.gymster.data.trainings.mapper

import com.maruchin.gymster.data.exercises.json.ExerciseBaseInfoJson
import com.maruchin.gymster.data.trainings.json.SetJson
import com.maruchin.gymster.data.trainings.json.SettingJson
import com.maruchin.gymster.data.trainings.model.Exercise

internal fun SetJson.toDomain(
    settingListJson: List<SettingJson>,
    exerciseBaseInfoJson: ExerciseBaseInfoJson
) = Exercise(
    id = id,
    name = exerciseBaseInfoJson.exercises.find { it.language == 2 }?.name.orEmpty(),
    sets = sets,
    reps = settingListJson.first().reps
)
