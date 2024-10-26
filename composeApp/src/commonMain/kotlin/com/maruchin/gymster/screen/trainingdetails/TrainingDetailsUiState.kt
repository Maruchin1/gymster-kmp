package com.maruchin.gymster.screen.trainingdetails

import com.maruchin.gymster.data.trainings.model.Training

internal data class TrainingDetailsUiState(
    val training: Training? = null,
    val notification: TrainingDetailsNotification? = null
)

enum class TrainingDetailsNotification {
    TRAINING_COMPLETED
}
