package com.maruchin.gymster.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
internal inline fun <reified T : Any> NavController.isRootSelected(): Boolean {
    val currentEntry by currentBackStackEntryAsState()
    return currentEntry?.destination?.hierarchy?.any { it.hasRoute<T>() } == true
}

internal fun NavController.navigateToRoot(rootRoute: Any) {
    navigate(rootRoute) {
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}
