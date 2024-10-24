package com.maruchin.gymster.ui.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.maruchin.gymster.core.ui.components.TrainingItem
import com.maruchin.gymster.data.trainings.model.TrainingWeek

@Composable
internal fun CurrentWeekWidget(
    trainingWeek: TrainingWeek?,
    onStartNewWeek: () -> Unit,
    onOpenTrainingHistory: () -> Unit,
    onOpenTraining: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Current week",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.weight(1f)
            )
            TextButton(onClick = onOpenTrainingHistory) {
                Text(text = "History")
            }
        }
        if (trainingWeek != null) {
            Card(modifier = Modifier.fillMaxWidth()) {
                Column {
                    trainingWeek.trainings.forEach { training ->
                        TrainingItem(
                            isComplete = training.isComplete,
                            name = training.name,
                            exercisesCount = training.exercises.size,
                            date = training.date,
                            onClick = { onOpenTraining(training.id) }
                        )
                        if (training != trainingWeek.trainings.last()) {
                            HorizontalDivider(
                                modifier = Modifier.padding(horizontal = 12.dp),
                                color = MaterialTheme.colorScheme.outline
                            )
                        }
                    }
                }
            }
        }
        OutlinedButton(onClick = onStartNewWeek, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Start new week")
        }
    }
}
