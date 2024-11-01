package com.maruchin.gymster.screen.exercisebrowser

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinNavViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@Serializable
internal data object ExerciseBrowserRoute

internal fun NavController.navigateToExerciseBrowser() {
    navigate(ExerciseBrowserRoute)
}

@OptIn(KoinExperimentalAPI::class)
internal fun NavGraphBuilder.exerciseBrowserScreen(onBack: () -> Unit) {
    composable<ExerciseBrowserRoute> {
        val viewModel = koinNavViewModel<ExerciseBrowserViewModel>()
        val state by viewModel.uiState.collectAsStateWithLifecycle()

        ExerciseBrowserScreen(
            state = state,
            onBack = onBack
        )
    }
}
