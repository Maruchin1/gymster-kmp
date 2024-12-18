package com.maruchin.gymster.screen.workouttemplate.component

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.maruchin.gymster.data.plans2.model.ExerciseTemplate

@Composable
internal fun ExerciseTemplateHeader(
    exerciseTemplate: ExerciseTemplate,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        Text(
            text = exerciseTemplate.exerciseBase.name,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )
    }
}
