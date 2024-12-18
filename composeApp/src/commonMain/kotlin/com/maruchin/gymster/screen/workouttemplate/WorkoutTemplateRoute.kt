package com.maruchin.gymster.screen.workouttemplate

import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.dialog
import androidx.navigation.toRoute
import com.maruchin.gymster.screen.startworkout.StartWorkoutRoute
import com.maruchin.gymster.screen.startworkout.StartWorkoutViewModel
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinNavViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.parameter.parametersOf

@Serializable
internal data class WorkoutTemplateRoute(val workoutId: Int)

internal fun NavController.navigateToWorkoutTemplate(workoutId: Int) {
    navigate(WorkoutTemplateRoute(workoutId))
}

@OptIn(KoinExperimentalAPI::class)
internal fun NavGraphBuilder.workoutTemplateScreen(
    navController: NavController,
    onClose: () -> Unit
) {
    dialog<WorkoutTemplateRoute>(
        dialogProperties = DialogProperties(usePlatformDefaultWidth = false)
    ) { entry ->
        val (workoutId) = entry.toRoute<WorkoutTemplateRoute>()
        val viewModel = koinNavViewModel<WorkoutTemplateViewModel> { parametersOf(workoutId) }
        val state by viewModel.uiState.collectAsStateWithLifecycle()

        val startWorkoutEntry = remember(entry) {
            navController.getBackStackEntry<StartWorkoutRoute>()
        }
        val startWorkoutViewModel = koinNavViewModel<StartWorkoutViewModel>(
            viewModelStoreOwner = startWorkoutEntry
        )

        DisposableEffect(Unit) {
            onDispose {
                startWorkoutViewModel.refresh()
            }
        }

        WorkoutTemplateScreen(
            state = state,
            onClose = onClose,
            onRenameWorkoutTemplate = viewModel::renameWorkoutTemplate,
            onClearError = viewModel::clearError
        )
    }
}
