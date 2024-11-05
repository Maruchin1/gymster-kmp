@file:OptIn(KoinExperimentalAPI::class)

package com.maruchin.gymster.screen.home

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinNavViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@Serializable
internal data object HomeRoute

internal fun NavController.navigateToHome() {
    navigate(HomeRoute) {
        popUpTo(graph.startDestinationId) {
            inclusive = true
        }
    }
}

@OptIn(KoinExperimentalAPI::class)
internal fun NavGraphBuilder.homeScreen(onOpenLogin: () -> Unit, onOpenProfile: () -> Unit) {
    composable<HomeRoute> {
        val viewModel = koinNavViewModel<HomeViewModel>()
        val state by viewModel.uiState.collectAsStateWithLifecycle()
        val session = state.session ?: return@composable

        if (!session.isLoggedIn) {
            LaunchedEffect(Unit) {
                onOpenLogin()
            }
        }

        HomeScreen(
            onOpenProfile = onOpenProfile
        )
    }
}
