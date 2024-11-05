package com.maruchin.gymster.screen.profile

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
internal data object ProfileRoute

internal fun NavController.navigateToProfile() {
    navigate(ProfileRoute)
}

@OptIn(KoinExperimentalAPI::class)
internal fun NavGraphBuilder.profileScreen(onBack: () -> Unit, onOpenLogin: () -> Unit) {
    composable<ProfileRoute> {
        val viewModel = koinNavViewModel<ProfileViewModel>()
        val state by viewModel.uiState.collectAsStateWithLifecycle()
        val session = state.session ?: return@composable

        if (!session.isLoggedIn) {
            LaunchedEffect(Unit) {
                onOpenLogin()
            }
        }

        ProfileScreen(
            onBack = onBack,
            onLogout = viewModel::logout
        )
    }
}
