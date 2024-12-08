package com.maruchin.gymster.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.maruchin.gymster.screen.startworkout.StartWorkoutRoute
import com.maruchin.gymster.screen.startworkout.startWorkoutScreen
import kotlinx.serialization.Serializable

@Serializable
internal data object WorkoutGraph

internal fun NavGraphBuilder.workoutGraph() {
    navigation<WorkoutGraph>(startDestination = StartWorkoutRoute) {
        startWorkoutScreen()
    }
}
