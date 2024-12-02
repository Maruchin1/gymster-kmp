package com.maruchin.gymster.data.trainings.mapper

import com.maruchin.gymster.data.trainings.json.PatchedSettingRequestJson
import com.maruchin.gymster.data.trainings.model.EditSetRequest

internal fun EditSetRequest.toJson() = PatchedSettingRequestJson(reps = reps, weight = weight)
