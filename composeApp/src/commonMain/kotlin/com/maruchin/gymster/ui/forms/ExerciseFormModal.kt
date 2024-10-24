package com.maruchin.gymster.ui.forms

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.maruchin.gymster.data.plans.model.PlanExercise
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ExerciseFormModal(
    exercise: PlanExercise?,
    onDismiss: () -> Unit,
    onSave: (name: String, sets: Int, reps: IntRange) -> Unit,
    onDelete: (() -> Unit)? = null
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val scope = rememberCoroutineScope()

    ModalBottomSheet(onDismissRequest = onDismiss, sheetState = sheetState) {
        ExerciseFormContent(
            exercise = exercise,
            onSave = { name, sets, reps ->
                scope.launch {
                    onSave(name, sets, reps)
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
private fun ExerciseFormContent(
    exercise: PlanExercise?,
    onSave: (name: String, sets: Int, reps: IntRange) -> Unit,
    onDelete: (() -> Unit)? = null
) {
    var exerciseName by rememberSaveable(exercise) {
        mutableStateOf(exercise?.name.orEmpty())
    }
    var sets by rememberSaveable(exercise) {
        mutableStateOf(exercise?.sets?.toString().orEmpty())
    }
    var minReps by rememberSaveable(exercise) {
        mutableStateOf(exercise?.reps?.first?.toString().orEmpty())
    }
    var maxReps by rememberSaveable(exercise) {
        mutableStateOf(exercise?.reps?.last?.toString().orEmpty())
    }

    val isValid by remember {
        derivedStateOf {
            arrayOf(exerciseName, sets, minReps, maxReps).all { it.isNotBlank() }
        }
    }

    Column {
        TopAppBar(
            title = {
                Text("Exercise")
            },
            actions = {
                if (onDelete != null) {
                    TextButton(onClick = onDelete) {
                        Text(text = "Delete")
                    }
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = BottomSheetDefaults.ContainerColor
            ),
            windowInsets = WindowInsets(0)
        )
        Spacer(modifier = Modifier.height(24.dp))
        OutlinedTextField(
            value = exerciseName,
            onValueChange = { exerciseName = it },
            label = {
                Text("Exercise name")
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row(modifier = Modifier.padding(horizontal = 16.dp)) {
            OutlinedTextField(
                value = sets,
                onValueChange = { sets = it },
                label = {
                    Text("Sets")
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                modifier = Modifier.weight(1f)
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Row(modifier = Modifier.padding(horizontal = 16.dp)) {
            OutlinedTextField(
                value = minReps,
                onValueChange = { minReps = it },
                label = {
                    Text("Min reps")
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            OutlinedTextField(
                value = maxReps,
                onValueChange = { maxReps = it },
                label = {
                    Text("Max reps")
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                modifier = Modifier.weight(1f)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                onSave(exerciseName, sets.toInt(), minReps.toInt()..maxReps.toInt())
            },
            enabled = isValid,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("Save")
        }
    }
}
