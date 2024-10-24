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
import com.maruchin.gymster.core.database.di.coreDatabaseModule
import com.maruchin.gymster.core.preferences.di.corePreferencesModule
import com.maruchin.gymster.core.ui.theme.AppTheme
import com.maruchin.gymster.core.utils.di.coreClockModule
import com.maruchin.gymster.data.plans.di.dataPlansModule
import com.maruchin.gymster.data.trainings.di.dataTrainingsModule
import com.maruchin.gymster.di.uiModule
import com.maruchin.gymster.ui.home.HomeRoute
import com.maruchin.gymster.ui.home.homeScreen
import com.maruchin.gymster.feature.plans.di.featurePlansModule
import com.maruchin.gymster.feature.trainings.di.featureTrainingsModule
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import org.koin.core.module.Module
import org.koin.dsl.module

// TODO Unify navigation routes naming
// TODO Unify packages naming in features

@Composable
@Preview
internal fun App(platformModule: Module = module { }) {
    KoinApplication(
        application = {
            modules(
                uiModule,
                featurePlansModule,
                featureTrainingsModule,
                dataPlansModule,
                dataTrainingsModule,
                coreDatabaseModule,
                corePreferencesModule,
                coreClockModule,
                platformModule
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
                    onOpenPlans = {},
                    onOpenPlan = {},
                    onOpenTrainingHistory = {},
                    onOpenTraining = {}
                )
            }
        }
    }
}
