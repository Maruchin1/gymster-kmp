package com.maruchin.gymster.feature.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
internal data object HomeScreen

internal fun NavGraphBuilder.homeScreen(onOpenPlans: () -> Unit, onOpenTrainings: () -> Unit) {
    composable<HomeScreen> {
        HomeScreen(
            onOpenPlans = onOpenPlans,
            onOpenTrainings = onOpenTrainings
        )
    }
}
