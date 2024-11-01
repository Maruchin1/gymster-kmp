package com.maruchin.gymster.screen.exercisebrowser

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.maruchin.gymster.screen.exercisebrowser.component.ExerciseBrowserTopAppBar
import com.maruchin.gymster.screen.exercisebrowser.component.ExerciseItem
import com.maruchin.gymster.screen.exercisebrowser.component.MoreExercisesLoader

@Composable
internal fun ExerciseBrowserScreen(
    state: ExerciseBrowserUiState,
    onBack: () -> Unit,
    onLoadNextPage: () -> Unit
) {
    Scaffold(
        topBar = {
            ExerciseBrowserTopAppBar(onBack = onBack)
        }
    ) { innerPadding ->
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier.padding(innerPadding)
        ) {
            items(state.exercises) { exercise ->
                ExerciseItem(exercise = exercise, onClick = {})
            }
            if (state.hasNextPage) {
                item {
                    LaunchedEffect(Unit) {
                        onLoadNextPage()
                    }
                    MoreExercisesLoader()
                }
            }
        }
    }
}
