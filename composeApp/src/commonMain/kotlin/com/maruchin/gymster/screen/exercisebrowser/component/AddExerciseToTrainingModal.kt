package com.maruchin.gymster.screen.exercisebrowser.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.maruchin.gymster.data.trainings.model.AddExerciseRequest
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun AddExerciseToTrainingModal(
    trainingId: Int,
    exerciseBaseId: Int,
    onDismiss: () -> Unit,
    onAdd: (AddExerciseRequest) -> Unit
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val scope = rememberCoroutineScope()

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState
    ) {
        AddExerciseToTrainingContent(
            trainingId = trainingId,
            exerciseBaseId = exerciseBaseId,
            onAdd = {
                onAdd(it)
                scope.launch {
                    sheetState.hide()
                    onDismiss()
                }
            }
        )
    }
}

@Composable
private fun AddExerciseToTrainingContent(
    trainingId: Int,
    exerciseBaseId: Int,
    onAdd: (AddExerciseRequest) -> Unit
) {
    var setsInput by rememberSaveable { mutableStateOf("") }
    var repsInput by rememberSaveable { mutableStateOf("") }

    val isValid by remember {
        derivedStateOf {
            setsInput.isNotBlank() && repsInput.isNotBlank()
        }
    }

    Column(modifier = Modifier.padding(24.dp), verticalArrangement = Arrangement.spacedBy(48.dp)) {
        Text(text = "Add to training", style = MaterialTheme.typography.displaySmall)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TextField(
                value = setsInput,
                onValueChange = { setsInput = it },
                label = { Text("Sets") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier.weight(1f)
            )
            TextField(
                value = repsInput,
                onValueChange = { repsInput = it },
                label = { Text("Reps") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                modifier = Modifier.weight(1f)
            )
        }
        Button(
            onClick = {
                val request = AddExerciseRequest(
                    trainingId = trainingId,
                    exerciseBaseId = exerciseBaseId,
                    sets = setsInput.toInt(),
                    reps = repsInput.toInt()
                )
                onAdd(request)
            },
            enabled = isValid,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add")
        }
    }
}
