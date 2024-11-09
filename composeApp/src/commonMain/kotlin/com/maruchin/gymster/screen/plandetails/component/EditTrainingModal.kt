package com.maruchin.gymster.screen.plandetails.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.maruchin.gymster.data.trainings.model.EditTrainingRequest
import com.maruchin.gymster.data.trainings.model.Training
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun EditTrainingModal(
    training: Training,
    onDismiss: () -> Unit,
    onSave: (EditTrainingRequest) -> Unit,
    modifier: Modifier = Modifier
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val scope = rememberCoroutineScope()

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        modifier = modifier
    ) {
        EditTrainingContent(
            training = training,
            onSave = {
                scope.launch {
                    sheetState.hide()
                    onSave(it)
                    onDismiss()
                }
            }
        )
    }
}

@Composable
private fun EditTrainingContent(training: Training, onSave: (EditTrainingRequest) -> Unit) {
    var nameInput by rememberSaveable { mutableStateOf(training.name) }

    Column(
        modifier = Modifier.fillMaxWidth().padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(48.dp)
    ) {
        Text(text = "Edit training", style = MaterialTheme.typography.displaySmall)
        TextField(
            value = nameInput,
            onValueChange = { nameInput = it },
            label = { Text("Training name") },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = {
                val request = EditTrainingRequest(id = training.id, name = nameInput)
                onSave(request)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Save")
        }
    }
}
