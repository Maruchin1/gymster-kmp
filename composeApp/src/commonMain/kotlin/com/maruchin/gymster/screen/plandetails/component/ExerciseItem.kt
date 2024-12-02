package com.maruchin.gymster.screen.plandetails.component

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.maruchin.gymster.data.trainings.model.Exercise

@Composable
internal fun ExerciseItem(exercise: Exercise, modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        Text(
            text = exercise.name,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )
    }
}
