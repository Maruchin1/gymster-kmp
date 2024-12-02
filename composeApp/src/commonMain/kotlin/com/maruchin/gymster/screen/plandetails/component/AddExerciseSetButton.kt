package com.maruchin.gymster.screen.plandetails.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.maruchin.gymster.data.trainings.model.AddSetRequest
import com.maruchin.gymster.data.trainings.model.Exercise

@Composable
internal fun AddExerciseSetButton(
    exercise: Exercise,
    onClick: (AddSetRequest) -> Unit,
    modifier: Modifier = Modifier
) {
    TextButton(
        onClick = {
            val request = AddSetRequest(
                exerciseId = exercise.id,
                exerciseBaseId = exercise.exerciseBaseId
            )
            onClick(request)
        },
        modifier = Modifier.fillMaxWidth().then(modifier)
    ) {
        Icon(
            imageVector = Icons.Rounded.Add,
            contentDescription = null,
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(modifier = Modifier.width(ButtonDefaults.IconSpacing))
        Text(text = "Add set")
    }
}
