package com.maruchin.gymster.screen.plandetails

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinNavViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.parameter.parametersOf

@Serializable
internal data class PlanDetailsRoute(val planId: Int)

internal fun NavController.navigatePlanDetails(planId: Int) {
    navigate(PlanDetailsRoute(planId))
}

@OptIn(KoinExperimentalAPI::class)
internal fun NavGraphBuilder.planDetailsScreen(onBack: () -> Unit) {
    composable<PlanDetailsRoute> { entry ->
        val (planId) = entry.toRoute<PlanDetailsRoute>()
        val viewModel = koinNavViewModel<PlanDetailsViewModel> { parametersOf(planId) }
        val state by viewModel.uiState.collectAsStateWithLifecycle()

        PlanDetailsScreen(
            state = state,
            onBack = onBack,
            onAddTraining = viewModel::addTraining,
            onEditTraining = viewModel::editTraining,
            onDeleteTraining = viewModel::deleteTraining,
            onClearError = viewModel::clearError
        )
    }
}
