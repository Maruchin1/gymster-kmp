package com.maruchin.gymster.feature.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import kotlinx.serialization.Serializable

@Serializable
data object HomeGraph

fun NavGraphBuilder.homeGraph(
    onOpenPlans: () -> Unit,
    onOpenPlan: (planId: String) -> Unit,
    onOpenTrainingHistory: () -> Unit,
    onOpenTraining: (String) -> Unit
) {
    navigation<HomeGraph>(startDestination = HomeScreen) {
        homeScreen(
            onOpenPlans = onOpenPlans,
            onOpenPlan = onOpenPlan,
            onOpenTrainingHistory = onOpenTrainingHistory,
            onOpenTraining = onOpenTraining
        )
    }
}
