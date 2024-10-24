package com.maruchin.gymster.ui.planlist

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinNavViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@Serializable
internal data object PlanListRoute

internal fun NavController.navigateToPlanList() {
    navigate(PlanListRoute)
}

@OptIn(KoinExperimentalAPI::class)
internal fun NavGraphBuilder.planListScreen(
    onBack: () -> Unit,
    onOpenPlan: (planId: String) -> Unit
) {
    composable<PlanListRoute> {
        val viewModel = koinNavViewModel<PlanListViewModel>()
        val state by viewModel.uiState.collectAsStateWithLifecycle()

        PlanListScreen(
            state = state,
            onBack = onBack,
            onSeedPlans = viewModel::seedPlans,
            onOpenPlan = onOpenPlan,
            onCreatePlan = viewModel::createPlan
        )
    }
}
