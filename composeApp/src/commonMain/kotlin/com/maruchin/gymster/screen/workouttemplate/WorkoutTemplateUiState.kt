package com.maruchin.gymster.screen.workouttemplate

import com.maruchin.gymster.data.plans2.model.WorkoutTemplate

internal data class WorkoutTemplateUiState(
    val workoutTemplate: WorkoutTemplate? = null,
    val isLoading: Boolean = true,
    val isError: Boolean = false
)
