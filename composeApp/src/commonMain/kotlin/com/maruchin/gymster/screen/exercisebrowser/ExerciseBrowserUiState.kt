package com.maruchin.gymster.screen.exercisebrowser

import com.maruchin.gymster.data.exercises.model.Exercise
import com.maruchin.gymster.data.exercises.model.ExerciseCategory

internal data class ExerciseBrowserUiState(
    val categories: List<ExerciseCategory> = emptyList(),
    val selectedCategory: ExerciseCategory? = null,
    val exercises: List<Exercise> = emptyList(),
    val nextPageIndex: Int? = 0
) {

    val hasNextPage: Boolean
        get() = nextPageIndex != null
}
