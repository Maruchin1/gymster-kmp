package com.maruchin.gymster.screen.plandetails.component

import androidx.compose.foundation.clickable
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.maruchin.gymster.data.trainings.model.Exercise

@Composable
internal fun ExerciseItem(
    index: Int,
    exercise: Exercise,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    ListItem(
        leadingContent = {
            Text(text = "${index + 1}.")
        },
        headlineContent = {
            Text(text = exercise.name)
        },
        supportingContent = {
            Text(text = "${exercise.sets} x ${exercise.reps} reps")
        },
        modifier = Modifier.clickable { onClick() }.then(modifier)
    )
}
