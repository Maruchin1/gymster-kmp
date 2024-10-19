package com.maruchin.gymster.feature.home

import com.maruchin.gymster.data.plans.model.Plan
import com.maruchin.gymster.data.trainings.model.TrainingWeek

internal data class HomeUiState(
    val activePlan: Plan? = null,
    val currentTrainingWeek: TrainingWeek? = null
)
