package com.maruchin.gymster.screen.workouttemplate

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.maruchin.gymster.data.plans2.model.RenameWorkoutTemplateRequest
import com.maruchin.gymster.screen.workouttemplate.component.EditableWorkoutTemplateName
import com.maruchin.gymster.screen.workouttemplate.component.WorkoutTemplateTopBar

@Composable
internal fun WorkoutTemplateScreen(
    state: WorkoutTemplateUiState,
    onClose: () -> Unit,
    onRenameWorkoutTemplate: (RenameWorkoutTemplateRequest) -> Unit,
    onClearError: () -> Unit
) {
    val snackbarHostState = remember { SnackbarHostState() }

    if (state.isError) {
        LaunchedEffect(Unit) {
            snackbarHostState.showSnackbar("Something went wrong")
            onClearError()
        }
    }

    Scaffold(
        topBar = {
            WorkoutTemplateTopBar(onClose = onClose, onSave = {})
        },
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        }
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
            if (state.workoutTemplate != null) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(innerPadding)
                ) {
                    EditableWorkoutTemplateName(
                        workoutTemplate = state.workoutTemplate,
                        onRenameWorkoutTemplate = onRenameWorkoutTemplate
                    )
                }
            }
            if (state.isLoading) {
                LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
            }
        }
    }
}
