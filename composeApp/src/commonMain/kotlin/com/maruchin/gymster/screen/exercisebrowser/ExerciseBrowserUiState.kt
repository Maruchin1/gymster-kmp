package com.maruchin.gymster.screen.exercisebrowser

import com.maruchin.gymster.data.exercises.model.Exercise

internal data class ExerciseBrowserUiState(val exercises: List<Exercise> = emptyList())
