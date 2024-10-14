package com.maruchin.gymster

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.maruchin.gymster.core.database.di.coreDatabaseModule
import com.maruchin.gymster.core.ui.theme.AppTheme
import com.maruchin.gymster.data.plans.di.dataPlansModule
import com.maruchin.gymster.feature.home.HomeGraph
import com.maruchin.gymster.feature.home.di.featureHomeModule
import com.maruchin.gymster.feature.home.homeGraph
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication

@Composable
@Preview
internal fun App() {
    KoinApplication(
        application = {
            modules(featureHomeModule, dataPlansModule, coreDatabaseModule)
        }
    ) {
        AppTheme {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = HomeGraph) {
                homeGraph()
            }
        }
    }
}
