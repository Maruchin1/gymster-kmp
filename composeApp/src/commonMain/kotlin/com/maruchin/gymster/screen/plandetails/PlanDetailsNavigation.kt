package com.maruchin.gymster.screen.plandetails

import androidx.compose.runtime.LaunchedEffect
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
internal data class PlanDetailsRoute(val planId: String)

internal fun NavController.navigateToPlanDetails(planId: String) {
    navigate(PlanDetailsRoute(planId))
}

@OptIn(KoinExperimentalAPI::class)
internal fun NavGraphBuilder.planDetailsScreen(onBack: () -> Unit) {
    composable<PlanDetailsRoute> { entry ->
        val (planId) = entry.toRoute<PlanDetailsRoute>()
        val viewModel: PlanDetailsViewModel = koinNavViewModel { parametersOf(planId) }
        val state by viewModel.uiState.collectAsStateWithLifecycle()

        if (state.isDeleted) {
            LaunchedEffect(Unit) {
                onBack()
            }
        }

        PlanDetailsScreen(
            state = state,
            onBack = onBack,
            onUpdatePlan = viewModel::changePlanName,
            onDeletePlan = viewModel::deletePlan,
            onAddTraining = viewModel::addTraining,
            onUpdateTraining = viewModel::updateTraining,
            onDeleteTraining = viewModel::deleteTraining,
            onAddExercise = viewModel::addExercise,
            onUpdateExercise = viewModel::updateExercise,
            onDeleteExercise = viewModel::deleteExercise,
            onActivatePlan = viewModel::activatePlan,
            onDeactivatePlan = viewModel::deactivatePlan,
            onClearNotification = viewModel::clearNotification
        )
    }
}
