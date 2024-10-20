package com.maruchin.gymster.feature.trainings.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.gymster.data.trainings.repository.TrainingsRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

internal class TrainingDetailsViewModel(
    private val trainingId: String,
    private val trainingsRepository: TrainingsRepository
) : ViewModel() {

    val uiState: StateFlow<TrainingDetailsUiState> = trainingsRepository.observeTraining(trainingId)
        .map { TrainingDetailsUiState(it) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = TrainingDetailsUiState()
        )

    fun completeTraining() {
        TODO("Not yet implemented")
    }

    fun updateSetResult(setResultId: String, weight: Double, reps: Int) = viewModelScope.launch {
        trainingsRepository.updateSetResult(setResultId, weight, reps)
    }
}
