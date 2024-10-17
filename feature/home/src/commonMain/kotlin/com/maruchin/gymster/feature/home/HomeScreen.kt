package com.maruchin.gymster.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
internal fun HomeScreen(state: HomeUiState, onOpenPlans: () -> Unit, onOpenTrainings: () -> Unit) {
    Scaffold(
        topBar = {
            TopBar()
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            PlansWidget(
                activePlan = state.activePlan,
                onOpenPlans = onOpenPlans,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun TopBar() {
    CenterAlignedTopAppBar(
        title = {
            Text("Gymster")
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
            }
        }
    )
}
