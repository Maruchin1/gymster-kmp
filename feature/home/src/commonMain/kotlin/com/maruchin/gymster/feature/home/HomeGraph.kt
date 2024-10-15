package com.maruchin.gymster.feature.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import kotlinx.serialization.Serializable

@Serializable
data object HomeGraph

fun NavGraphBuilder.homeGraph(onOpenPlans: () -> Unit, onOpenTrainings: () -> Unit) {
    navigation<HomeGraph>(startDestination = HomeScreen) {
        homeScreen(
            onOpenPlans = onOpenPlans,
            onOpenTrainings = onOpenTrainings
        )
    }
}
