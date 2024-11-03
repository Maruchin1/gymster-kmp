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
import com.maruchin.gymster.di.backendModule
import com.maruchin.gymster.di.clockModule
import com.maruchin.gymster.di.dataModule
import com.maruchin.gymster.di.databaseModule
import com.maruchin.gymster.di.preferencesModule
import com.maruchin.gymster.di.screenModule
import com.maruchin.gymster.screen.exercisebrowser.exerciseBrowserScreen
import com.maruchin.gymster.screen.exercisebrowser.navigateToExerciseBrowser
import com.maruchin.gymster.screen.home.homeScreen
import com.maruchin.gymster.screen.login.LoginRoute
import com.maruchin.gymster.screen.login.loginScreen
import com.maruchin.gymster.screen.plandetails.navigateToPlanDetails
import com.maruchin.gymster.screen.plandetails.planDetailsScreen
import com.maruchin.gymster.screen.planlist.planListScreen
import com.maruchin.gymster.screen.trainingdetails.navigateToTrainingDetails
import com.maruchin.gymster.screen.trainingdetails.trainingDetailsScreen
import com.maruchin.gymster.screen.traininghistory.navigateToTrainingHistory
import com.maruchin.gymster.screen.traininghistory.trainingHistoryScreen
import com.maruchin.gymster.ui.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import org.koin.core.module.Module
import org.koin.dsl.module

// TODO Unify navigation routes naming
// TODO Unify packages naming in features

// TODO Try Ktor Http Cache

@Composable
@Preview
internal fun App(appModule: Module = module { }) {
    KoinApplication(
        application = {
            modules(
                screenModule,
                dataModule,
                clockModule,
                databaseModule,
                preferencesModule,
                backendModule,
                appModule
            )
        }
    ) {
        AppTheme {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = LoginRoute,
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
                    onOpenPlans = { navController.navigateToExerciseBrowser() },
                    onOpenPlan = { navController.navigateToPlanDetails(it) },
                    onOpenTrainingHistory = { navController.navigateToTrainingHistory() },
                    onOpenTraining = { navController.navigateToTrainingDetails(it) }
                )
                planListScreen(
                    onBack = { navController.navigateUp() },
                    onOpenPlan = { navController.navigateToPlanDetails(it) }
                )
                planDetailsScreen(
                    onBack = { navController.navigateUp() }
                )
                trainingHistoryScreen(
                    onBack = { navController.navigateUp() },
                    onOpenTraining = { navController.navigateToTrainingDetails(it) }
                )
                trainingDetailsScreen(
                    onBack = { navController.navigateUp() }
                )
                loginScreen(
                    onLoginSuccess = { } // TODO navigate to home
                )
                exerciseBrowserScreen(
                    onBack = { navController.navigateUp() }
                )
            }
        }
    }
}
