package com.maruchin.gymster.screen.exercisebrowser.component

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.maruchin.gymster.data.exercises.model.ExerciseCategory

@Composable
internal fun CategorySelector(
    categories: List<ExerciseCategory>,
    selectedCategory: ExerciseCategory?,
    onCategoryChange: (ExerciseCategory?) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
            .then(modifier)
    ) {
        FilterChip(
            selected = selectedCategory == null,
            onClick = { onCategoryChange(null) },
            label = {
                Text(text = "All")
            }
        )
        categories.forEach { category ->
            FilterChip(
                selected = category == selectedCategory,
                onClick = { onCategoryChange(category) },
                label = {
                    Text(text = category.name)
                }
            )
        }
    }
}
