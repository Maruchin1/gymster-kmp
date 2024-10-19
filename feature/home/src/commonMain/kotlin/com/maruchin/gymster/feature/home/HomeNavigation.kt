@file:OptIn(KoinExperimentalAPI::class)

package com.maruchin.gymster.feature.home

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinNavViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@Serializable
internal data object HomeScreen

internal fun NavGraphBuilder.homeScreen(
    onOpenPlans: () -> Unit,
    onOpenPlan: (planId: String) -> Unit
) {
    composable<HomeScreen> {
        val viewModel = koinNavViewModel<HomeViewModel>()
        val state by viewModel.uiState.collectAsStateWithLifecycle()

        HomeScreen(
            state = state,
            onOpenPlans = onOpenPlans,
            onOpenPlan = onOpenPlan,
            onStartNewWeek = viewModel::startNewWeek
        )
    }
}
