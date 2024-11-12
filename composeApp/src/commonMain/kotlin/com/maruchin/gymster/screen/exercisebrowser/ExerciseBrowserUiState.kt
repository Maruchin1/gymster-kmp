package com.maruchin.gymster.screen.exercisebrowser

import com.maruchin.gymster.data.exercises.model.ExerciseBase
import com.maruchin.gymster.data.exercises.model.ExerciseCategory

internal data class ExerciseBrowserUiState(
    val searchTerm: String = "",
    val categories: List<ExerciseCategory> = emptyList(),
    val selectedCategory: ExerciseCategory? = null,
    val exerciseBases: List<ExerciseBase> = emptyList(),
    val status: ExerciseBrowserStatus = ExerciseBrowserStatus.LOADING
) {

    val filteredExerciseBases: List<ExerciseBase> = exerciseBases
        .asSequence()
        .filter { it.name.contains(searchTerm, ignoreCase = true) }
        .filter { selectedCategory == null || it.category == selectedCategory }
        .sortedBy { it.name }
        .toList()
}

internal enum class ExerciseBrowserStatus {
    IDLE,
    LOADING,
    ERROR
}
