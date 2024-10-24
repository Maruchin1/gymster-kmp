package com.maruchin.gymster.ui.traininghistory

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinNavViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@Serializable
internal data object TrainingHistoryRoute

internal fun NavController.navigateToTrainingHistory() {
    navigate(TrainingHistoryRoute)
}

@OptIn(KoinExperimentalAPI::class)
internal fun NavGraphBuilder.trainingHistoryScreen(
    onBack: () -> Unit,
    onOpenTraining: (String) -> Unit
) {
    composable<TrainingHistoryRoute> {
        val viewModel = koinNavViewModel<TrainingHistoryViewModel>()
        val state by viewModel.uiState.collectAsStateWithLifecycle()

        TrainingHistoryScreen(state = state, onBack = onBack, onOpenTraining = onOpenTraining)
    }
}
