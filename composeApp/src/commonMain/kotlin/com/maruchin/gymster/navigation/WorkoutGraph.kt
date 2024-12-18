package com.maruchin.gymster.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.maruchin.gymster.screen.exercisebrowser.exerciseBrowserDialog
import com.maruchin.gymster.screen.exercisebrowser.navigateToExerciseBrowser
import com.maruchin.gymster.screen.startworkout.StartWorkoutRoute
import com.maruchin.gymster.screen.startworkout.startWorkoutScreen
import com.maruchin.gymster.screen.workouttemplate.navigateToWorkoutTemplate
import com.maruchin.gymster.screen.workouttemplate.workoutTemplateScreen
import kotlinx.serialization.Serializable

// TODO WorkoutEditorScreen

@Serializable
internal data object WorkoutGraph

internal fun NavGraphBuilder.workoutGraph(navController: NavController) {
    navigation<WorkoutGraph>(startDestination = StartWorkoutRoute) {
        startWorkoutScreen(
            onEditWorkout = { navController.navigateToWorkoutTemplate(it) }
        )
        workoutTemplateScreen(
            navController = navController,
            onClose = { navController.navigateUp() },
            onAddExercise = { navController.navigateToExerciseBrowser(it) }
        )
        exerciseBrowserDialog(
            navController = navController,
            onClose = { navController.navigateUp() }
        )
    }
}
