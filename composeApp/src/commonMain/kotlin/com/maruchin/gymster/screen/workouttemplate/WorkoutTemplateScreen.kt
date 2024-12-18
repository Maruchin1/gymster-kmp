package com.maruchin.gymster.screen.workouttemplate

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import com.maruchin.gymster.data.plans2.model.AddSetTemplateRequest
import com.maruchin.gymster.data.plans2.model.RenameWorkoutTemplateRequest
import com.maruchin.gymster.screen.workouttemplate.component.AddExerciseButton
import com.maruchin.gymster.screen.workouttemplate.component.AddSetTemplateButton
import com.maruchin.gymster.screen.workouttemplate.component.EditableWorkoutTemplateName
import com.maruchin.gymster.screen.workouttemplate.component.ExerciseTemplateHeader
import com.maruchin.gymster.screen.workouttemplate.component.SetTemplateItem
import com.maruchin.gymster.screen.workouttemplate.component.SetTemplateLabels
import com.maruchin.gymster.screen.workouttemplate.component.WorkoutTemplateTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun WorkoutTemplateScreen(
    state: WorkoutTemplateUiState,
    onClose: () -> Unit,
    onRenameWorkoutTemplate: (RenameWorkoutTemplateRequest) -> Unit,
    onClearError: () -> Unit,
    onAddExercise: (workoutTemplateId: Int) -> Unit,
    onAddSetTemplate: (AddSetTemplateRequest) -> Unit,
    onDeleteSetTemplate: (Int) -> Unit
) {
    val topAppBarScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val snackbarHostState = remember { SnackbarHostState() }

    if (state.isError) {
        LaunchedEffect(Unit) {
            snackbarHostState.showSnackbar("Something went wrong")
            onClearError()
        }
    }

    Scaffold(
        topBar = {
            WorkoutTemplateTopBar(
                scrollBehavior = topAppBarScrollBehavior,
                onClose = onClose,
                onSave = {}
            )
        },
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        }
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
            if (state.workoutTemplate != null) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .nestedScroll(topAppBarScrollBehavior.nestedScrollConnection)
                ) {
                    item {
                        EditableWorkoutTemplateName(
                            workoutTemplate = state.workoutTemplate,
                            onRenameWorkoutTemplate = onRenameWorkoutTemplate
                        )
                    }
                    state.workoutTemplate.exercises.forEach { exerciseTemplate ->
                        item {
                            ExerciseTemplateHeader(
                                exerciseTemplate = exerciseTemplate,
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                        item {
                            SetTemplateLabels(
                                modifier = Modifier
                                    .padding(horizontal = 16.dp)
                                    .padding(bottom = 8.dp)
                            )
                        }
                        item {
                            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                                exerciseTemplate.sets.forEachIndexed { index, setTemplate ->
                                    SetTemplateItem(
                                        index = index,
                                        setTemplate = setTemplate,
                                        onEdit = {},
                                        onDelete = onDeleteSetTemplate,
                                        modifier = Modifier.padding(start = 16.dp, end = 8.dp)
                                    )
                                }
                            }
                        }
                        item {
                            AddSetTemplateButton(
                                exerciseTemplate = exerciseTemplate,
                                onClick = onAddSetTemplate,
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                    }
                    item {
                        AddExerciseButton(
                            onAddExercise = {
                                onAddExercise(state.workoutTemplate.id)
                            },
                            modifier = Modifier.fillMaxWidth().padding(16.dp)
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
