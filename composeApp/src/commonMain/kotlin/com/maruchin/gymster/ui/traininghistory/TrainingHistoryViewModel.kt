package com.maruchin.gymster.ui.traininghistory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.gymster.data.trainings.repository.TrainingsRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

internal class TrainingHistoryViewModel(private val trainingsRepository: TrainingsRepository) :
    ViewModel() {

    val uiState: StateFlow<TrainingHistoryUiState> = trainingsRepository.observeAllTrainingWeeks()
        .map { TrainingHistoryUiState(it) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = TrainingHistoryUiState()
        )
}
