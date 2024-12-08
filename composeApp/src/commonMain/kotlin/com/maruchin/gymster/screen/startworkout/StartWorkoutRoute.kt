package com.maruchin.gymster.screen.startworkout

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinNavViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@Serializable
internal data object StartWorkoutRoute

@OptIn(KoinExperimentalAPI::class)
internal fun NavGraphBuilder.startWorkoutScreen() {
    composable<StartWorkoutRoute> {
        val viewModel = koinNavViewModel<StartWorkoutViewModel>()
        val state by viewModel.uiState.collectAsStateWithLifecycle()

        StartWorkoutScreen(
            state = state,
            onClearFailure = viewModel::clearFailure,
            onAddPlan = viewModel::addPlan,
            onRenamePlan = viewModel::renamePlan,
            onDeletePlan = viewModel::deletePlan,
            onAddWorkout = viewModel::addWorkout
        )
    }
}
