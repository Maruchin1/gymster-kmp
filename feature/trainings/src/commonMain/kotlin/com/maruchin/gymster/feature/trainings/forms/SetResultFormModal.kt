package com.maruchin.gymster.feature.trainings.forms

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.maruchin.gymster.core.utils.format.format
import com.maruchin.gymster.data.trainings.model.SetResult
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SetResultFormModal(
    index: Int,
    expectedReps: IntRange,
    setResult: SetResult,
    onDismiss: () -> Unit,
    onSave: (setResultId: String, weight: Double, reps: Int) -> Unit
) {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()

    ModalBottomSheet(onDismissRequest = onDismiss, sheetState = sheetState) {
        SetResultFormContent(
            index = index,
            expectedReps = expectedReps,
            setResult = setResult,
            onSave = { weight, reps ->
                onSave(setResult.id, weight, reps)
                scope.launch {
                    sheetState.hide()
                    onDismiss()
                }
            }
        )
    }
}

@Composable
private fun SetResultFormContent(
    index: Int,
    expectedReps: IntRange,
    setResult: SetResult,
    onSave: (weight: Double, reps: Int) -> Unit
) {
    val setNumber = index + 1

    var weightInput by rememberSaveable(setResult.weight) {
        mutableStateOf(setResult.weight?.toString().orEmpty())
    }
    var repsInput by rememberSaveable(setResult.reps) {
        mutableStateOf(setResult.reps?.toString().orEmpty())
    }

    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(48.dp)) {
        Text(text = "Set $setNumber", style = MaterialTheme.typography.headlineSmall)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TextField(
                value = weightInput,
                onValueChange = { weightInput = it },
                label = { Text("Weight") },
                suffix = { Text("kg") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                singleLine = true,
                modifier = Modifier.weight(1f)
            )
            TextField(
                value = repsInput,
                onValueChange = { repsInput = it },
                label = { Text("Reps") },
                placeholder = { Text(expectedReps.format()) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = Modifier.weight(1f)
            )
        }
        Button(
            onClick = { onSave(weightInput.toDouble(), repsInput.toInt()) },
            enabled = weightInput.isNotBlank() && repsInput.isNotBlank(),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save")
        }
    }
}
