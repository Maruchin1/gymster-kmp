package com.maruchin.gymster.screen.trainingdetails

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
internal data class TrainingDetailsRoute(val trainingId: String)

internal fun NavController.navigateToTrainingDetails(trainingId: String) {
    navigate(TrainingDetailsRoute(trainingId))
}

@OptIn(KoinExperimentalAPI::class)
internal fun NavGraphBuilder.trainingDetailsScreen(onBack: () -> Unit) {
    composable<TrainingDetailsRoute> { entry ->
        val (trainingId) = entry.toRoute<TrainingDetailsRoute>()
        val viewModel = koinNavViewModel<TrainingDetailsViewModel> { parametersOf(trainingId) }
        val state by viewModel.uiState.collectAsStateWithLifecycle()

        TrainingDetailsScreen(
            state = state,
            onBack = onBack,
            onComplete = viewModel::completeTraining,
            onUpdateSetResult = viewModel::updateSetResult,
            onClearNotification = viewModel::clearNotification,
            onUpdateTrainingDate = viewModel::updateTrainingDate
        )
    }
}
