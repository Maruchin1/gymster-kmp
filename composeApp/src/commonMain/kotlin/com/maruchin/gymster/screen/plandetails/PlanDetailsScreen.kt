package com.maruchin.gymster.screen.plandetails

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
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
import com.maruchin.gymster.data.trainings.model.AddSetRequest
import com.maruchin.gymster.data.trainings.model.AddTrainingRequest
import com.maruchin.gymster.data.trainings.model.EditSetRequest
import com.maruchin.gymster.data.trainings.model.EditTrainingRequest
import com.maruchin.gymster.screen.plandetails.component.AddExerciseSetButton
import com.maruchin.gymster.screen.plandetails.component.ExerciseItem
import com.maruchin.gymster.screen.plandetails.component.ExerciseSetItem
import com.maruchin.gymster.screen.plandetails.component.ExerciseSetLabels
import com.maruchin.gymster.screen.plandetails.component.NoTrainingsPlaceholder
import com.maruchin.gymster.screen.plandetails.component.PlanDetailsTopAppBar
import com.maruchin.gymster.screen.plandetails.component.TrainingActions
import com.maruchin.gymster.screen.plandetails.component.TrainingTabs

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
    onAddSet: (AddSetRequest) -> Unit,
    onEditSet: (EditSetRequest) -> Unit,
    onDeleteSet: (Int) -> Unit,
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
                if (state.trainings.isEmpty()) {
                    NoTrainingsPlaceholder(planId = state.plan.id, onAddTraining = onAddTraining)
                } else {
                    val pagerState = rememberPagerState { state.trainings.size }

                    Column {
                        TrainingTabs(
                            planId = state.plan.id,
                            trainings = state.trainings,
                            pagerState = pagerState,
                            onAddTraining = onAddTraining
                        )
                        HorizontalPager(state = pagerState) { page ->
                            val training = state.trainings[page]

                            LazyColumn(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .nestedScroll(topAppBarScrollBehavior.nestedScrollConnection)
                            ) {
                                training.exercises.forEach { exercise ->
                                    item {
                                        ExerciseItem(
                                            exercise = exercise,
                                            modifier = Modifier.padding(16.dp)
                                        )
                                    }
                                    item {
                                        ExerciseSetLabels(
                                            modifier = Modifier.padding(horizontal = 16.dp)
                                        )
                                    }
                                    item {
                                        Spacer(modifier = Modifier.height(8.dp))
                                    }
                                    item {
                                        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                                            exercise.sets.forEachIndexed { index, exerciseSet ->
                                                ExerciseSetItem(
                                                    index = index,
                                                    set = exerciseSet,
                                                    onEdit = onEditSet,
                                                    onDelete = onDeleteSet,
                                                    modifier = Modifier.padding(
                                                        start = 16.dp,
                                                        end = 8.dp
                                                    )
                                                )
                                            }
                                        }
                                    }
                                    item {
                                        AddExerciseSetButton(
                                            exercise = exercise,
                                            onClick = onAddSet,
                                            modifier = Modifier.padding(16.dp)
                                        )
                                    }
                                    item {
                                        HorizontalDivider()
                                    }
                                }
                                item {
                                    TrainingActions(
                                        training = training,
                                        onAddExercise = onAddExercise,
                                        onEditTraining = onEditTraining,
                                        onDeleteTraining = onDeleteTraining,
                                        modifier = Modifier.padding(16.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
            if (state.isLoading) {
                LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
            }
        }
    }
}
