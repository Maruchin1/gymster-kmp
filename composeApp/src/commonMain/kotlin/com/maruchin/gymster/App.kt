package com.maruchin.gymster

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.maruchin.gymster.di.appModules
import com.maruchin.gymster.navigation.MainNavigationBar
import com.maruchin.gymster.navigation.WorkoutGraph
import com.maruchin.gymster.navigation.workoutGraph
import com.maruchin.gymster.ui.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import org.koin.core.module.Module
import org.koin.dsl.module

// TODO Update dependencies

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

            Scaffold(
                bottomBar = {
                    MainNavigationBar(navController)
                },
                contentWindowInsets = ScaffoldDefaults.contentWindowInsets
                    .only(WindowInsetsSides.Bottom)
            ) { innerPadding ->
                NavHost(
                    navController = navController,
                    startDestination = WorkoutGraph,
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
                    modifier = Modifier.padding(innerPadding)
                ) {
                    workoutGraph(navController)
                }
            }
        }
    }
}
