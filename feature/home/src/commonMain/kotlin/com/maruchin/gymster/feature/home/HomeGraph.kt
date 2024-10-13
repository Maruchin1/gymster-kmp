package com.maruchin.gymster.feature.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import kotlinx.serialization.Serializable

@Serializable
data object HomeGraph

fun NavGraphBuilder.homeGraph() {
    navigation<HomeGraph>(startDestination = HomeScreen) {
        homeScreen(
            onOpenPlans = {},
            onOpenTrainings = {}
        )
    }
}
