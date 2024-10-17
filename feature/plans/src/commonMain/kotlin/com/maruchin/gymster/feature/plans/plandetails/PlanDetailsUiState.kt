package com.maruchin.gymster.feature.plans.plandetails

import com.maruchin.gymster.data.plans.model.Plan

data class PlanDetailsUiState(val plan: Plan? = null, val isDeleted: Boolean = false)
