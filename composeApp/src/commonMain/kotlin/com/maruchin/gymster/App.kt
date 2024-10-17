package com.maruchin.gymster

import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.maruchin.gymster.core.database.di.coreDatabaseModule
import com.maruchin.gymster.core.preferences.di.corePreferencesModule
import com.maruchin.gymster.core.ui.theme.AppTheme
import com.maruchin.gymster.data.plans.di.dataPlansModule
import com.maruchin.gymster.feature.home.HomeGraph
import com.maruchin.gymster.feature.home.di.featureHomeModule
import com.maruchin.gymster.feature.home.homeGraph
import com.maruchin.gymster.feature.plans.di.featurePlansModule
import com.maruchin.gymster.feature.plans.navigateToPlans
import com.maruchin.gymster.feature.plans.plansGraph
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import org.koin.core.module.Module
import org.koin.dsl.module

// TODO Add data module for trainings

@Composable
@Preview
internal fun App(platformModule: Module = module { }) {
    KoinApplication(
        application = {
            modules(
                featureHomeModule,
                featurePlansModule,
                dataPlansModule,
                coreDatabaseModule,
                corePreferencesModule,
                platformModule
            )
        }
    ) {
        AppTheme {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = HomeGraph,
                modifier = Modifier.background(MaterialTheme.colorScheme.background)
            ) {
                homeGraph(
                    onOpenPlans = { navController.navigateToPlans() },
                    onOpenPlan = { navController.navigateToPlans(it) }
                )
                plansGraph(navController)
            }
        }
    }
}
