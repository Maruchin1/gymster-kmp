@file:OptIn(KoinExperimentalAPI::class)

package com.maruchin.gymster.screen.home

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinNavViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@Serializable
internal data object HomeRoute

@OptIn(KoinExperimentalAPI::class)
internal fun NavGraphBuilder.homeScreen(
    onOpenPlans: () -> Unit,
    onOpenPlan: (planId: String) -> Unit,
    onOpenTrainingHistory: () -> Unit,
    onOpenTraining: (String) -> Unit
) {
    composable<HomeRoute> {
        val viewModel = koinNavViewModel<HomeViewModel>()
        val state by viewModel.uiState.collectAsStateWithLifecycle()

        HomeScreen(
            state = state,
            onOpenPlans = onOpenPlans,
            onOpenPlan = onOpenPlan,
            onStartNewWeek = viewModel::startNewWeek,
            onOpenTrainingHistory = onOpenTrainingHistory,
            onOpenTraining = onOpenTraining
        )
    }
}
