package com.maruchin.gymster.screen.plandetails

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
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
import com.maruchin.gymster.data.plans.model.EditPlanRequest
import com.maruchin.gymster.data.trainings.model.AddTrainingRequest
import com.maruchin.gymster.data.trainings.model.EditTrainingRequest
import com.maruchin.gymster.screen.plandetails.component.AddExerciseButton
import com.maruchin.gymster.screen.plandetails.component.AddTrainingButton
import com.maruchin.gymster.screen.plandetails.component.ExerciseItem
import com.maruchin.gymster.screen.plandetails.component.PlanDetailsTopAppBar
import com.maruchin.gymster.screen.plandetails.component.TrainingHeader

// TODO Option to edit and delete exercise

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
internal fun PlanDetailsScreen(
    state: PlanDetailsUiState,
    onBack: () -> Unit,
    onEditPlan: (EditPlanRequest) -> Unit,
    onDeletePlan: (Int) -> Unit,
    onAddTraining: (AddTrainingRequest) -> Unit,
    onEditTraining: (EditTrainingRequest) -> Unit,
    onDeleteTraining: (Int) -> Unit,
    onAddExercise: (trainingId: Int) -> Unit,
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
                onBack = onBack,
                onEditPlan = onEditPlan,
                onDeletePlan = onDeletePlan
            )
        },
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        }
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize().padding(innerPadding).imePadding()) {
            if (state.plan != null) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .nestedScroll(topAppBarScrollBehavior.nestedScrollConnection)
                ) {
                    state.trainings.forEach { training ->
                        stickyHeader(key = "training${training.id}") {
                            TrainingHeader(
                                training = training,
                                onEditTraining = onEditTraining,
                                onDeleteTraining = onDeleteTraining
                            )
                        }
                        training.exercises.forEachIndexed { index, exercise ->
                            item(key = "exercise${exercise.id}") {
                                ExerciseItem(index = index, exercise = exercise, onClick = {})
                                HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
                            }
                        }
                        item(key = "addExerciseButton${training.id}") {
                            AddExerciseButton(
                                onClick = { onAddExercise(training.id) },
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                    }
                    item(key = "addTrainingButton") {
                        AddTrainingButton(
                            planId = state.plan.id,
                            onAddTraining = onAddTraining,
                            modifier = Modifier.padding(16.dp)
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
