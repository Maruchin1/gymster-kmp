package com.maruchin.gymster.feature.plans.forms

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.unit.dp
import com.maruchin.gymster.data.plans.model.PlanTraining
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun TrainingFormModal(
    training: PlanTraining?,
    onDismiss: () -> Unit,
    onSave: (newName: String) -> Unit,
    onDelete: (() -> Unit)? = null
) {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()

    ModalBottomSheet(onDismissRequest = onDismiss, sheetState = sheetState) {
        TrainingFormContent(
            training = training,
            onSave = { newName ->
                scope.launch {
                    onSave(newName)
                    sheetState.hide()
                    onDismiss()
                }
            },
            onDelete = onDelete
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TrainingFormContent(
    training: PlanTraining?,
    onSave: (newName: String) -> Unit,
    onDelete: (() -> Unit)? = null
) {
    val trainingNameFocus = remember { FocusRequester() }
    var trainingName by remember(training) { mutableStateOf(training?.name.orEmpty()) }

    LaunchedEffect(Unit) {
        delay(300)
        trainingNameFocus.requestFocus()
    }

    Column {
        TopAppBar(
            title = {
                Text(text = "Training")
            },
            actions = {
                if (onDelete != null) {
                    TextButton(onClick = {}) {
                        Text(text = "Delete")
                    }
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = BottomSheetDefaults.ContainerColor
            ),
            windowInsets = WindowInsets(0)
        )
        OutlinedTextField(
            value = trainingName,
            onValueChange = { trainingName = it },
            label = {
                Text(text = "Training name")
            },
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(trainingNameFocus)
                .padding(horizontal = 16.dp, vertical = 24.dp)
        )
        Button(
            onClick = { onSave(trainingName) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Save")
        }
    }
}
