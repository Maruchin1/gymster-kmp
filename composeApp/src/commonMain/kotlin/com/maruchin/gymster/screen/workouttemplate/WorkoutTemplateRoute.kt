package com.maruchin.gymster.screen.workouttemplate

import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.dialog
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

@Serializable
internal data class WorkoutTemplateRoute(val workoutId: Int)

internal fun NavController.navigateToWorkoutTemplate(workoutId: Int) {
    navigate(WorkoutTemplateRoute(workoutId))
}

internal fun NavGraphBuilder.workoutTemplateScreen(onClose: () -> Unit) {
    dialog<WorkoutTemplateRoute>(
        dialogProperties = DialogProperties(usePlatformDefaultWidth = false)
    ) { entry ->
        val (_) = entry.toRoute<WorkoutTemplateRoute>()
        WorkoutTemplateScreen(
            onClose = onClose
        )
    }
}
