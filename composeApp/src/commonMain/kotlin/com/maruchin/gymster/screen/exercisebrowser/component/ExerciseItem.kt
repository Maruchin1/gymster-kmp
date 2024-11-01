package com.maruchin.gymster.screen.exercisebrowser.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.maruchin.gymster.data.exercises.model.Exercise

@Composable
internal fun ExerciseItem(exercise: Exercise, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Card(modifier = modifier, onClick = onClick) {
        Row {
            AsyncImage(
                model = exercise.images.firstOrNull(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(100.dp)
                    .background(Color.White)
                    .aspectRatio(1f / 1f)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier.padding(12.dp).weight(1f)
            ) {
                Text(
                    text = exercise.category.name,
                    style = MaterialTheme.typography.labelLarge,
                    maxLines = 1
                )
                Text(
                    text = exercise.name,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 2
                )
            }
        }
    }
}
