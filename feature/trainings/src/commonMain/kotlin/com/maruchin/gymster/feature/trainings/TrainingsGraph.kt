package com.maruchin.gymster.feature.trainings

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.maruchin.gymster.feature.trainings.history.TrainingHistoryRoute
import com.maruchin.gymster.feature.trainings.history.trainingHistoryScreen
import kotlinx.serialization.Serializable

@Serializable
data object TrainingsGraph

fun NavController.navigateToTrainings() {
    navigate(TrainingsGraph)
}

fun NavGraphBuilder.trainingsGraph(navController: NavController) {
    navigation<TrainingsGraph>(startDestination = TrainingHistoryRoute) {
        trainingHistoryScreen(
            onBack = { navController.navigateUp() }
        )
    }
}
