package com.maruchin.gymster.screen.startworkout

import com.maruchin.gymster.data.plans2.model.Plan

internal data class StartWorkoutUiState(
    val plans: List<Plan> = emptyList(),
    val isLoading: Boolean = true,
    val isFailure: Boolean = false
)
