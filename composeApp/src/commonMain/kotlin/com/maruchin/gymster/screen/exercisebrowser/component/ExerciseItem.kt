package com.maruchin.gymster.screen.exercisebrowser.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.maruchin.gymster.data.exercises.model.Exercise
import com.maruchin.gymster.data.trainings.model.AddExerciseRequest

@Composable
internal fun ExerciseItem(
    trainingId: Int,
    exercise: Exercise,
    onAddToTraining: (AddExerciseRequest) -> Unit,
    modifier: Modifier = Modifier
) {
    var isAddingToTraining by rememberSaveable { mutableStateOf(false) }

    ListItem(
        headlineContent = {
            Text(text = exercise.name)
        },
        supportingContent = {
            Text(text = exercise.category.name)
        },
        leadingContent = {
            AsyncImage(
                model = exercise.images.firstOrNull(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White)
            )
        },
        modifier = Modifier.clickable { isAddingToTraining = true }.then(modifier)
    )

    if (isAddingToTraining) {
        AddExerciseToTrainingModal(
            trainingId = trainingId,
            exerciseBaseId = exercise.id,
            onDismiss = { isAddingToTraining = false },
            onAdd = onAddToTraining
        )
    }
}
