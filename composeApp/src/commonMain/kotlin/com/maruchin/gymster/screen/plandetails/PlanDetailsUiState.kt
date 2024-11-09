package com.maruchin.gymster.screen.plandetails

import com.maruchin.gymster.data.plans.model.Plan
import com.maruchin.gymster.data.trainings.model.Training

internal data class PlanDetailsUiState(
    val plan: Plan? = null,
    val trainings: List<Training> = emptyList(),
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val isDeleted: Boolean = false
)
