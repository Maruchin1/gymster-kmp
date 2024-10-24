package com.maruchin.gymster.feature.plans.planlist

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinNavViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@Serializable
internal data object PlanListScreen

@OptIn(KoinExperimentalAPI::class)
internal fun NavGraphBuilder.planListScreen(
    onBack: () -> Unit,
    onOpenPlan: (planId: String) -> Unit
) {
    composable<PlanListScreen> {
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
