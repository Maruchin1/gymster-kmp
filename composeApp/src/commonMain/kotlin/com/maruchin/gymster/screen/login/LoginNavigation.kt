package com.maruchin.gymster.screen.login

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
internal data object LoginRoute

internal fun NavController.navigateToLogin() {
    navigate(LoginRoute) {
        popUpTo(graph.startDestinationId) {
            inclusive = true
        }
    }
}

@OptIn(KoinExperimentalAPI::class)
internal fun NavGraphBuilder.loginScreen(onLoginSuccess: () -> Unit) {
    composable<LoginRoute> {
        val viewModel = koinNavViewModel<LoginViewModel>()
        val state by viewModel.uiState.collectAsStateWithLifecycle()

        if (state.result == LoginResult.SUCCESS) {
            LaunchedEffect(Unit) {
                onLoginSuccess()
            }
        }

        LoginScreen(
            state = state,
            onLogin = viewModel::login
        )
    }
}
