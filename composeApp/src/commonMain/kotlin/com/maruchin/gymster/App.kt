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
import com.maruchin.gymster.feature.home.HomeGraph
import com.maruchin.gymster.feature.home.di.featureHomeModule
import com.maruchin.gymster.feature.home.homeGraph
import com.maruchin.gymster.feature.plans.di.featurePlansModule
import com.maruchin.gymster.feature.plans.navigateToPlans
import com.maruchin.gymster.feature.plans.plansGraph
import com.maruchin.gymster.feature.trainings.di.featureTrainingsModule
import com.maruchin.gymster.feature.trainings.navigateToTrainings
import com.maruchin.gymster.feature.trainings.trainingsGraph
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
                featureHomeModule,
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
                startDestination = HomeGraph,
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
                homeGraph(
                    onOpenPlans = { navController.navigateToPlans() },
                    onOpenPlan = { navController.navigateToPlans(it) },
                    onOpenTrainingHistory = { navController.navigateToTrainings() },
                    onOpenTraining = { navController.navigateToTrainings(it) }
                )
                plansGraph(navController)
                trainingsGraph(navController)
            }
        }
    }
}
