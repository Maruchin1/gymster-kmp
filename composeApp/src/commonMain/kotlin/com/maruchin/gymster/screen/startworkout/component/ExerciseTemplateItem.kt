package com.maruchin.gymster.screen.startworkout.component

import androidx.compose.foundation.background
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
import com.maruchin.gymster.data.plans2.model.ExerciseTemplate

@Composable
internal fun ExerciseTemplateItem(
    exerciseTemplate: ExerciseTemplate,
    modifier: Modifier = Modifier
) {
    ListItem(
        headlineContent = {
            Text(text = "${exerciseTemplate.sets.size} x ${exerciseTemplate.exerciseBase.name}")
        },
        supportingContent = {
            Text(text = exerciseTemplate.exerciseBase.category.name)
        },
        leadingContent = {
            AsyncImage(
                model = exerciseTemplate.exerciseBase.images.firstOrNull(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White)
            )
        },
        modifier = modifier
    )
}
