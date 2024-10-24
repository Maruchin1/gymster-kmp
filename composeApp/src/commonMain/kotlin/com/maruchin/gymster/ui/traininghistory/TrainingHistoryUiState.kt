package com.maruchin.gymster.ui.traininghistory

import com.maruchin.gymster.data.trainings.model.TrainingWeek

internal data class TrainingHistoryUiState(val trainingWeeks: List<TrainingWeek> = emptyList())
