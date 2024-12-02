package com.maruchin.gymster.screen.plandetails.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.FitnessCenter
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
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
import com.maruchin.gymster.data.trainings.model.AddTrainingRequest

@Composable
internal fun NoTrainingsPlaceholder(
    planId: Int,
    onAddTraining: (AddTrainingRequest) -> Unit,
    modifier: Modifier = Modifier
) {
    var isAdding by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize().then(modifier),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(2f))
        Icon(
            imageVector = Icons.Rounded.FitnessCenter,
            contentDescription = null,
            modifier = Modifier.size(48.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(text = "No trainings in this plan", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = { isAdding = true }) {
            Text(text = "Add training")
        }
        Spacer(modifier = Modifier.weight(3f))
    }

    if (isAdding) {
        AddTrainingModal(
            planId = planId,
            onDismiss = { isAdding = false },
            onSave = onAddTraining
        )
    }
}
