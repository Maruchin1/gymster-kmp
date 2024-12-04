package com.maruchin.gymster.screen.login

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.maruchin.gymster.data.session.model.LoginResult
import com.maruchin.gymster.screen.home.HomeRoute
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinNavViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@Serializable
internal data object LoginRoute

internal fun NavController.navigateToLogin() {
    navigate(LoginRoute) {
        popUpTo(HomeRoute) {
            inclusive = true
        }
    }
}

@OptIn(KoinExperimentalAPI::class)
internal fun NavGraphBuilder.loginScreen(onOpenHome: () -> Unit) {
    composable<LoginRoute> {
        val viewModel = koinNavViewModel<LoginViewModel>()
        val state by viewModel.uiState.collectAsStateWithLifecycle()

        if (state.result is LoginResult.Success) {
            LaunchedEffect(Unit) {
                onOpenHome()
            }
        }

        LoginScreen(
            state = state,
            onLogin = viewModel::login
        )
    }
}
