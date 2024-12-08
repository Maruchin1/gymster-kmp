package com.maruchin.gymster.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.FitnessCenter
import androidx.compose.material.icons.rounded.History
import androidx.compose.material.icons.rounded.MonitorWeight
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.maruchin.gymster.screen.startworkout.StartWorkoutRoute

@Composable
fun MainNavigationBar(navController: NavController, modifier: Modifier = Modifier) {
    NavigationBar(modifier = modifier) {
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = {
                Icon(imageVector = Icons.Rounded.Person, contentDescription = null)
            },
            label = {
                Text(text = "Profile")
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = {
                Icon(imageVector = Icons.Rounded.History, contentDescription = null)
            },
            label = {
                Text(text = "History")
            }
        )
        NavigationBarItem(
            selected = navController.isRootSelected<StartWorkoutRoute>(),
            onClick = { navController.navigateToRoot(StartWorkoutRoute) },
            icon = {
                Icon(imageVector = Icons.Rounded.Add, contentDescription = null)
            },
            label = {
                Text(text = "Workout")
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = {
                Icon(imageVector = Icons.Rounded.FitnessCenter, contentDescription = null)
            },
            label = {
                Text(text = "Exercises")
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = {
                Icon(imageVector = Icons.Rounded.MonitorWeight, contentDescription = null)
            },
            label = {
                Text(text = "Measure")
            }
        )
    }
}
