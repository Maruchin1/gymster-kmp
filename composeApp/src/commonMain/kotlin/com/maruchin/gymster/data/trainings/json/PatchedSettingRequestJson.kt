package com.maruchin.gymster.data.trainings.json

import kotlinx.serialization.Serializable

@Serializable
internal data class PatchedSettingRequestJson(val reps: Int, val weight: Double?)
