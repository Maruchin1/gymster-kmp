package com.maruchin.gymster.screen.home

import com.maruchin.gymster.data.plans.model.Plan
import com.maruchin.gymster.data.session.model.Session
import com.maruchin.gymster.data.trainings.model.TrainingWeek

internal data class HomeUiState(
    val session: Session? = null,
    val activePlan: Plan? = null,
    val currentTrainingWeek: TrainingWeek? = null
)
