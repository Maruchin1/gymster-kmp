package com.maruchin.gymster.screen.exercisebrowser.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.maruchin.gymster.data.exercises.model.ExerciseBase
import com.maruchin.gymster.data.plans2.model.AddExerciseTemplateRequest

@Composable
internal fun ExerciseItem(
    workoutTemplateId: Int,
    exerciseBase: ExerciseBase,
    onAddToTraining: (AddExerciseTemplateRequest) -> Unit,
    modifier: Modifier = Modifier
) {
    ListItem(
        headlineContent = {
            Text(text = exerciseBase.name)
        },
        supportingContent = {
            Text(text = exerciseBase.category.name)
        },
        leadingContent = {
            AsyncImage(
                model = exerciseBase.images.firstOrNull(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White)
            )
        },
        modifier = Modifier
            .clickable {
                val request = AddExerciseTemplateRequest(workoutTemplateId, exerciseBase.id)
                onAddToTraining(request)
            }
            .then(modifier)
    )
}
