package com.maruchin.gymster.data.trainings.json

import kotlinx.serialization.Serializable

@Serializable
internal data class SetJson(val id: Int, val sets: Int)
