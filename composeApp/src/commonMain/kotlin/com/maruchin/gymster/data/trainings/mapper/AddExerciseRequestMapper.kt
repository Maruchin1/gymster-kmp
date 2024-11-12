package com.maruchin.gymster.data.trainings.mapper

import com.maruchin.gymster.data.trainings.json.SetJson
import com.maruchin.gymster.data.trainings.json.SetRequestJson
import com.maruchin.gymster.data.trainings.json.SettingRequestJson
import com.maruchin.gymster.data.trainings.model.AddExerciseRequest

internal fun AddExerciseRequest.toSetRequestJson() = SetRequestJson(
    exerciseDay = trainingId,
    sets = sets
)

internal fun AddExerciseRequest.toSettingRequestJson(setJson: SetJson) = (1..sets).map {
    SettingRequestJson(
        set = setJson.id,
        exerciseBase = exerciseBaseId,
        reps = reps
    )
}
