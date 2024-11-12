package com.maruchin.gymster.screen.exercisebrowser

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.maruchin.gymster.data.exercises.model.ExerciseCategory
import com.maruchin.gymster.data.trainings.model.AddExerciseRequest
import com.maruchin.gymster.screen.exercisebrowser.component.CategorySelector
import com.maruchin.gymster.screen.exercisebrowser.component.ExerciseBrowserTopAppBar
import com.maruchin.gymster.screen.exercisebrowser.component.ExerciseItem
import com.maruchin.gymster.screen.exercisebrowser.component.ExerciseSearchField

@Composable
internal fun ExerciseBrowserScreen(
    trainingId: Int,
    state: ExerciseBrowserUiState,
    onBack: () -> Unit,
    onSearchTermChange: (String) -> Unit,
    onCategoryChange: (ExerciseCategory?) -> Unit,
    onAddExerciseToTraining: (AddExerciseRequest) -> Unit,
    onResetStatus: () -> Unit
) {
    val snackbarHostState = remember { SnackbarHostState() }

    if (state.status == ExerciseBrowserStatus.ERROR) {
        LaunchedEffect(Unit) {
            snackbarHostState.showSnackbar("Something went wrong")
            onResetStatus()
        }
    }

    Scaffold(
        topBar = {
            ExerciseBrowserTopAppBar(onBack = onBack)
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
            Column(modifier = Modifier.fillMaxSize()) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.padding(16.dp)
                ) {
                    ExerciseSearchField(
                        term = state.searchTerm,
                        onTermChange = onSearchTermChange
                    )
                    if (state.categories.isNotEmpty()) {
                        CategorySelector(
                            categories = state.categories,
                            selectedCategory = state.selectedCategory,
                            onCategoryChange = onCategoryChange
                        )
                    }
                }
                LazyColumn(modifier = Modifier.weight(1f)) {
                    items(state.filteredExercises) { exercise ->
                        ExerciseItem(
                            trainingId = trainingId,
                            exercise = exercise,
                            onAddToTraining = onAddExerciseToTraining
                        )
                        HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
                    }
                }
            }
            if (state.status == ExerciseBrowserStatus.LOADING) {
                LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
            }
        }
    }
}
