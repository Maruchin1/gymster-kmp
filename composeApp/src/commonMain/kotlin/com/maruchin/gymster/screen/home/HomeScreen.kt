package com.maruchin.gymster.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.maruchin.gymster.screen.home.component.ActivePlanWidget
import com.maruchin.gymster.screen.home.component.CurrentWeekWidget

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun HomeScreen(
    state: HomeUiState,
    onOpenPlans: () -> Unit,
    onOpenPlan: (planId: String) -> Unit,
    onStartNewWeek: () -> Unit,
    onOpenTrainingHistory: () -> Unit,
    onOpenTraining: (String) -> Unit
) {
    val topAppBarScrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    Scaffold(
        topBar = {
            TopBar(topAppBarScrollBehavior = topAppBarScrollBehavior)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .nestedScroll(topAppBarScrollBehavior.nestedScrollConnection)
        ) {
            ActivePlanWidget(
                activePlan = state.activePlan,
                onOpenPlans = onOpenPlans,
                onOpenPlan = onOpenPlan,
                modifier = Modifier.padding(16.dp)
            )
            CurrentWeekWidget(
                trainingWeek = state.currentTrainingWeek,
                onStartNewWeek = onStartNewWeek,
                onOpenTrainingHistory = onOpenTrainingHistory,
                onOpenTraining = onOpenTraining,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun TopBar(topAppBarScrollBehavior: TopAppBarScrollBehavior) {
    CenterAlignedTopAppBar(
        title = {
            Text("Gymster")
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
            }
        },
        scrollBehavior = topAppBarScrollBehavior
    )
}
