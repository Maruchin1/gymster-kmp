package com.maruchin.gymster.data.trainings.mapper

import com.maruchin.gymster.data.trainings.json.PatchedDayRequestJson
import com.maruchin.gymster.data.trainings.model.EditTrainingRequest

internal fun EditTrainingRequest.toJson() = PatchedDayRequestJson(description = name)
