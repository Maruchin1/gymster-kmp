package com.maruchin.gymster.screen.plandetails

import com.maruchin.gymster.data.plans.model.Plan

internal data class PlanDetailsUiState(
    val plan: Plan? = null,
    val isDeleted: Boolean = false,
    val notification: PlanDetailsNotification? = null
)

internal enum class PlanDetailsNotification {
    PLAN_ACTIVATED,
    PLAN_DEACTIVATED
}
