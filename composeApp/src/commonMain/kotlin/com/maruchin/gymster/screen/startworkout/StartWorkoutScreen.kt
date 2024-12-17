package com.maruchin.gymster.screen.startworkout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan
import androidx.compose.foundation.lazy.staggeredgrid.items
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
import com.maruchin.gymster.data.plans2.model.AddPlanRequest
import com.maruchin.gymster.data.plans2.model.AddWorkoutRequest
import com.maruchin.gymster.data.plans2.model.RenamePlanRequest
import com.maruchin.gymster.screen.startworkout.component.PlanHeader
import com.maruchin.gymster.screen.startworkout.component.StartWorkoutTopBar
import com.maruchin.gymster.screen.startworkout.component.WorkoutTemplateItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun StartWorkoutScreen(
    state: StartWorkoutUiState,
    onClearFailure: () -> Unit,
    onAddPlan: (AddPlanRequest) -> Unit,
    onRenamePlan: (RenamePlanRequest) -> Unit,
    onDeletePlan: (Int) -> Unit,
    onAddWorkout: (AddWorkoutRequest) -> Unit,
    onEditWorkout: (Int) -> Unit
) {
    val topAppBarScrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val snackbarHostState = remember { SnackbarHostState() }

    if (state.isFailure) {
        LaunchedEffect(Unit) {
            snackbarHostState.showSnackbar("Something went wrong")
            onClearFailure()
        }
    }

    Scaffold(
        topBar = {
            StartWorkoutTopBar(
                scrollBehavior = topAppBarScrollBehavior,
                onAddPlan = onAddPlan
            )
        },
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(2),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalItemSpacing = 16.dp,
                modifier = Modifier
                    .fillMaxSize()
                    .nestedScroll(topAppBarScrollBehavior.nestedScrollConnection)
            ) {
                state.plans.forEach { plan ->
                    item(span = StaggeredGridItemSpan.FullLine) {
                        PlanHeader(
                            plan = plan,
                            onAddWorkout = onAddWorkout,
                            onRenamePlan = onRenamePlan,
                            onDeletePlan = onDeletePlan
                        )
                    }
                    items(plan.workouts) { workoutTemplate ->
                        WorkoutTemplateItem(
                            workoutTemplate = workoutTemplate,
                            onEdit = { onEditWorkout(workoutTemplate.id) }
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
