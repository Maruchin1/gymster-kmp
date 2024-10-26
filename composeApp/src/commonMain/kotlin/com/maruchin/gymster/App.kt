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
import com.maruchin.gymster.di.coreModule
import com.maruchin.gymster.di.dataModule
import com.maruchin.gymster.di.platformModule
import com.maruchin.gymster.di.uiModule
import com.maruchin.gymster.screen.home.HomeRoute
import com.maruchin.gymster.screen.home.homeScreen
import com.maruchin.gymster.screen.plandetails.navigateToPlanDetails
import com.maruchin.gymster.screen.plandetails.planDetailsScreen
import com.maruchin.gymster.screen.planlist.navigateToPlanList
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

@Composable
@Preview
internal fun App(appModule: Module = module { }) {
    KoinApplication(
        application = {
            modules(
                uiModule,
                dataModule,
                coreModule,
                platformModule,
                appModule
            )
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
                    onOpenPlans = { navController.navigateToPlanList() },
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
            }
        }
    }
}
