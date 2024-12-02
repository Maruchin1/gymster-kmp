package com.maruchin.gymster.data.trainings.mapper

import com.maruchin.gymster.data.trainings.json.SetRequestJson
import com.maruchin.gymster.data.trainings.model.AddExerciseRequest

internal fun AddExerciseRequest.toJson() = SetRequestJson(exerciseDay = trainingId)
