package com.maruchin.gymster.data.trainings.json

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class SetRequestJson(@SerialName("exerciseday") val exerciseDay: Int, val sets: Int)
