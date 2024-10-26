package com.maruchin.gymster.data.trainings.model

import kotlin.uuid.Uuid

internal data class SetResult(
    val id: String = Uuid.random().toString(),
    val weight: Double? = null,
    val reps: Int? = null
) {

    val isComplete: Boolean
        get() = weight != null && reps != null
}
