package com.maruchin.gymster.screen.workouttemplate.component

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun AddExerciseButton(onAddExercise: () -> Unit, modifier: Modifier = Modifier) {
    Button(onClick = onAddExercise, modifier = modifier) {
        Text(text = "Add Exercise")
    }
}
