package com.maruchin.gymster

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.maruchin.gymster.di.appModules
import com.maruchin.gymster.screen.exercisebrowser.exerciseBrowserScreen
import com.maruchin.gymster.screen.home.HomeRoute
import com.maruchin.gymster.screen.home.homeScreen
import com.maruchin.gymster.screen.home.navigateToHome
import com.maruchin.gymster.screen.login.loginScreen
import com.maruchin.gymster.screen.login.navigateToLogin
import com.maruchin.gymster.screen.planlist.navigateToPlanList
import com.maruchin.gymster.screen.planlist.planListScreen
import com.maruchin.gymster.screen.profile.navigateToProfile
import com.maruchin.gymster.screen.profile.profileScreen
import com.maruchin.gymster.ui.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import org.koin.core.module.Module
import org.koin.dsl.module

// TODO Try Ktor Http Cache

@Composable
@Preview
internal fun App(externalModule: Module = module { }) {
    KoinApplication(
        application = {
            modules(appModules + externalModule)
        }
    ) {
        AppTheme {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = HomeRoute,
                enterTransition = {
                    slideInHorizontally(initialOffsetX = { it }) + fadeIn()
                },
                exitTransition = {
                    slideOutHorizontally(targetOffsetX = { -it }) + fadeOut()
                },
                popEnterTransition = {
                    slideInHorizontally(initialOffsetX = { -it }) + fadeIn()
                },
                popExitTransition = {
                    slideOutHorizontally(targetOffsetX = { it }) + fadeOut()
                },
                modifier = Modifier.background(MaterialTheme.colorScheme.background)
            ) {
                homeScreen(
                    onOpenLogin = { navController.navigateToLogin() },
                    onOpenProfile = { navController.navigateToProfile() },
                    onOpenAllPlans = { navController.navigateToPlanList() }
                )
                loginScreen(
                    onOpenHome = { navController.navigateToHome() }
                )
                profileScreen(
                    onBack = { navController.navigateUp() },
                    onOpenLogin = { navController.navigateToLogin() }
                )
                planListScreen(
                    onBack = { navController.navigateUp() },
                    onOpenPlan = {}
                )
                exerciseBrowserScreen(
                    onBack = { navController.navigateUp() }
                )
            }
        }
    }
}
