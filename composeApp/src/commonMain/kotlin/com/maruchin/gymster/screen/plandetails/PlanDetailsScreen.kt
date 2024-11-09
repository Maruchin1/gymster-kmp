package com.maruchin.gymster.screen.plandetails

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.maruchin.gymster.data.trainings.model.AddTrainingRequest
import com.maruchin.gymster.data.trainings.model.EditTrainingRequest
import com.maruchin.gymster.screen.plandetails.component.AddExerciseButton
import com.maruchin.gymster.screen.plandetails.component.AddTrainingButton
import com.maruchin.gymster.screen.plandetails.component.PlanDetailsTopAppBar
import com.maruchin.gymster.screen.plandetails.component.TrainingHeader

// TODO Option to add exercises to training

// TODO Option to change training name

// TODO Option to change plan name

// TODO Option to delete plan

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
internal fun PlanDetailsScreen(
    state: PlanDetailsUiState,
    onBack: () -> Unit,
    onAddTraining: (AddTrainingRequest) -> Unit,
    onEditTraining: (EditTrainingRequest) -> Unit,
    onDeleteTraining: (Int) -> Unit,
    onClearError: () -> Unit
) {
    val topAppBarScrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val snackbarHostState = remember { SnackbarHostState() }

    if (state.isError) {
        LaunchedEffect(Unit) {
            snackbarHostState.showSnackbar("Something went wrong")
            onClearError()
        }
    }

    Scaffold(
        topBar = {
            PlanDetailsTopAppBar(
                plan = state.plan,
                scrollBehavior = topAppBarScrollBehavior,
                onBack = onBack
            )
        },
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        }
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
            if (state.plan != null) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .nestedScroll(topAppBarScrollBehavior.nestedScrollConnection),
                    verticalArrangement = Arrangement.spacedBy(24.dp)
                ) {
                    state.trainings.forEach { training ->
                        stickyHeader(key = "training${training.id}") {
                            TrainingHeader(
                                training = training,
                                onEditTraining = onEditTraining,
                                onDeleteTraining = onDeleteTraining
                            )
                        }
                        item(key = "addExerciseButton${training.id}") {
                            AddExerciseButton(modifier = Modifier.padding(horizontal = 16.dp))
                        }
                    }
                    item(key = "addTrainingButton") {
                        AddTrainingButton(
                            planId = state.plan.id,
                            onAddTraining = onAddTraining,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                    }
                }
            }
            if (state.isLoading) {
                LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
            }
        }
    }
}
