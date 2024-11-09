package com.maruchin.gymster.screen.plandetails.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreHoriz
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.maruchin.gymster.data.trainings.model.EditTrainingRequest
import com.maruchin.gymster.data.trainings.model.Training

@Composable
internal fun TrainingHeader(
    training: Training,
    onEditTraining: (EditTrainingRequest) -> Unit,
    onDeleteTraining: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    var isMenuOpen by rememberSaveable { mutableStateOf(false) }
    var isEditing by rememberSaveable { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxWidth().then(modifier)) {
        HorizontalDivider()
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = training.name, style = MaterialTheme.typography.titleLarge)
            Box {
                IconButton(onClick = { isMenuOpen = true }) {
                    Icon(imageVector = Icons.Rounded.MoreHoriz, contentDescription = null)
                }
                TrainingMenu(
                    expanded = isMenuOpen,
                    onDismiss = { isMenuOpen = false },
                    onChangeName = { isEditing = true },
                    onDeleteTraining = { onDeleteTraining(training.id) }
                )
            }
        }
        HorizontalDivider()
    }

    if (isEditing) {
        EditTrainingModal(
            training = training,
            onDismiss = { isEditing = false },
            onSave = onEditTraining
        )
    }
}
