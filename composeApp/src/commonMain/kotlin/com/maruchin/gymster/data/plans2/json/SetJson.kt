package com.maruchin.gymster.data.plans2.json

import kotlinx.serialization.Serializable

@Serializable
internal data class SetJson(val id: Int, val sets: Int, val order: Int)
