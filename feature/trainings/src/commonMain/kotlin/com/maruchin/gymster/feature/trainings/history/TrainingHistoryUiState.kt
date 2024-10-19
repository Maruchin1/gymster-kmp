package com.maruchin.gymster.feature.trainings.history

import com.maruchin.gymster.data.trainings.model.TrainingWeek

internal data class TrainingHistoryUiState(val trainingWeeks: List<TrainingWeek> = emptyList())
