package com.maruchin.gymster.screen.plandetails.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.maruchin.gymster.data.trainings.model.AddTrainingRequest

@Composable
internal fun AddTrainingButton(
    planId: Int,
    onAddTraining: (AddTrainingRequest) -> Unit,
    modifier: Modifier = Modifier
) {
    var isAddingTraining by rememberSaveable { mutableStateOf(false) }

    Button(
        onClick = { isAddingTraining = true },
        modifier = Modifier.fillMaxWidth().then(modifier)
    ) {
        Text(text = "Add training")
    }

    if (isAddingTraining) {
        AddTrainingModal(
            planId = planId,
            onDismiss = { isAddingTraining = false },
            onSave = onAddTraining
        )
    }
}
