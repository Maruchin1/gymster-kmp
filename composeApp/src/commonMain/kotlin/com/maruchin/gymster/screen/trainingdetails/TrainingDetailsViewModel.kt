package com.maruchin.gymster.screen.trainingdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.gymster.data.trainings.TrainingsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.datetime.LocalDate

internal class TrainingDetailsViewModel(
    private val trainingId: String,
    private val trainingsRepository: TrainingsRepository
) : ViewModel() {

    private val notification = MutableStateFlow<TrainingDetailsNotification?>(null)

    val uiState: StateFlow<TrainingDetailsUiState> = combine(
        trainingsRepository.observeTraining(trainingId),
        notification,
        ::TrainingDetailsUiState
    ).stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = TrainingDetailsUiState()
    )

    fun completeTraining() = viewModelScope.launch {
        trainingsRepository.completeTraining(trainingId)
        notification.value = TrainingDetailsNotification.TRAINING_COMPLETED
    }

    fun updateSetResult(setResultId: String, weight: Double, reps: Int) = viewModelScope.launch {
        trainingsRepository.updateSetResult(setResultId, weight, reps)
    }

    fun clearNotification() {
        notification.value = null
    }

    fun updateTrainingDate(localDate: LocalDate) = viewModelScope.launch {
        trainingsRepository.updateTraining(trainingId, localDate)
    }
}
