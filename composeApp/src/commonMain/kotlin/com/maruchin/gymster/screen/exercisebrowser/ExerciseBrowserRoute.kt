package com.maruchin.gymster.screen.exercisebrowser

import androidx.compose.runtime.getValue
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.dialog
import androidx.navigation.toRoute
import com.maruchin.gymster.screen.plandetails.PlanDetailsRoute
import com.maruchin.gymster.screen.plandetails.PlanDetailsViewModel
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinNavViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@Serializable
internal data class ExerciseBrowserRoute(val trainingId: Int)

internal fun NavController.navigateToExerciseBrowser(trainingId: Int) {
    navigate(ExerciseBrowserRoute(trainingId))
}

@OptIn(KoinExperimentalAPI::class)
internal fun NavGraphBuilder.exerciseBrowserDialog(
    navController: NavController,
    onClose: () -> Unit
) {
    dialog<ExerciseBrowserRoute>(
        dialogProperties = DialogProperties(usePlatformDefaultWidth = false)
    ) { entry ->
        val (trainingId) = entry.toRoute<ExerciseBrowserRoute>()
        val planDetailsEntry = navController.getBackStackEntry<PlanDetailsRoute>()
        val planDetailsViewModel = koinNavViewModel<PlanDetailsViewModel>(
            viewModelStoreOwner = planDetailsEntry
        )
        val viewModel = koinNavViewModel<ExerciseBrowserViewModel>()
        val state by viewModel.uiState.collectAsStateWithLifecycle()

        ExerciseBrowserScreen(
            trainingId = trainingId,
            state = state,
            onBack = onClose,
            onSearchTermChange = viewModel::searchExercises,
            onCategoryChange = viewModel::selectCategory,
            onAddExerciseToTraining = {
                planDetailsViewModel.addExercise(it)
                onClose()
            },
            onResetStatus = viewModel::resetStatus
        )
    }
}
