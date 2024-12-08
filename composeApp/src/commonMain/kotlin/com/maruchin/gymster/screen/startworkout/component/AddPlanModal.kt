package com.maruchin.gymster.screen.startworkout.component

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
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.maruchin.gymster.data.plans2.model.AddPlanRequest
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun AddPlanModal(onDismiss: () -> Unit, onSave: (AddPlanRequest) -> Unit) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val scope = rememberCoroutineScope()

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState
    ) {
        AddPlanContent(
            onSave = {
                scope.launch {
                    sheetState.hide()
                    onDismiss()
                    onSave(it)
                }
            }
        )
    }
}

@Composable
private fun AddPlanContent(onSave: (AddPlanRequest) -> Unit) {
    var nameInput by rememberSaveable { mutableStateOf("") }

    val canSave by remember {
        derivedStateOf {
            nameInput.isNotBlank()
        }
    }

    Column(
        modifier = Modifier.fillMaxWidth().padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(48.dp)
    ) {
        Text(text = "Add plan", style = MaterialTheme.typography.displaySmall)
        TextField(
            value = nameInput,
            onValueChange = { nameInput = it },
            placeholder = {
                Text(text = "Full Body Workout")
            },
            label = {
                Text(text = "Plan name")
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ),
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = {
                val addPlanRequest = AddPlanRequest(name = nameInput)
                onSave(addPlanRequest)
            },
            enabled = canSave,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Save")
        }
    }
}
