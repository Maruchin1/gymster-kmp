package com.maruchin.gymster

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.maruchin.gymster.core.ui.theme.AppTheme
import com.maruchin.gymster.feature.home.HomeGraph
import com.maruchin.gymster.feature.home.homeGraph
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
internal fun App() {
    AppTheme {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = HomeGraph) {
            homeGraph()
        }
    }
}
