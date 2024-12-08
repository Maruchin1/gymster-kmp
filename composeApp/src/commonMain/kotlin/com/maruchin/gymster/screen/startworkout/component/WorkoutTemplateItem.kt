package com.maruchin.gymster.screen.startworkout.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.maruchin.gymster.data.plans2.model.WorkoutTemplate

@Composable
internal fun WorkoutTemplateItem(
    workoutTemplate: WorkoutTemplate,
    modifier: Modifier = Modifier
) {
    var isPreviewOpen by rememberSaveable { mutableStateOf(false) }

    OutlinedCard(
        modifier = Modifier.fillMaxWidth().then(modifier),
        onClick = { isPreviewOpen = true }
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = workoutTemplate.name,
                style = MaterialTheme.typography.titleMedium
            )
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                workoutTemplate.exercises.forEach { exercise ->
                    Text(
                        text = exercise.exerciseBase.name,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }

    if (isPreviewOpen) {
        WorkoutTemplatePreviewDialog(
            workoutTemplate = workoutTemplate,
            onDismiss = { isPreviewOpen = false }
        )
    }
}
