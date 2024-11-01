package com.maruchin.gymster.screen.exercisebrowser

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.maruchin.gymster.data.exercises.model.ExerciseCategory
import com.maruchin.gymster.screen.exercisebrowser.component.CategorySelector
import com.maruchin.gymster.screen.exercisebrowser.component.ExerciseBrowserTopAppBar
import com.maruchin.gymster.screen.exercisebrowser.component.ExerciseItem
import com.maruchin.gymster.screen.exercisebrowser.component.ExercisesLoaded
import com.maruchin.gymster.screen.exercisebrowser.component.MoreExercisesLoader

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ExerciseBrowserScreen(
    state: ExerciseBrowserUiState,
    onBack: () -> Unit,
    onLoadNextPage: () -> Unit,
    onSelectCategoryChange: (ExerciseCategory?) -> Unit
) {
    val topAppBarScrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    Scaffold(
        topBar = {
            ExerciseBrowserTopAppBar(onBack = onBack, scrollBehavior = topAppBarScrollBehavior)
        }
    ) { innerPadding ->
        Column(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
            if (state.categories.isNotEmpty()) {
                CategorySelector(
                    categories = state.categories,
                    selectedCategory = state.selectedCategory,
                    onSelectedCategoryChange = onSelectCategoryChange
                )
            }
            if (state.exercises.isNotEmpty()) {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(16.dp),
                    modifier = Modifier
                        .weight(1f)
                        .nestedScroll(topAppBarScrollBehavior.nestedScrollConnection)
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
            } else {
                ExercisesLoaded(modifier = Modifier.weight(1f))
            }
        }
    }
}
