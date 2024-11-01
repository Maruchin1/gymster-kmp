package com.maruchin.gymster.screen.exercisebrowser

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.gymster.data.exercises.ExercisesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class ExerciseBrowserViewModel(private val exercisesRepository: ExercisesRepository) :
    ViewModel() {

    private val _uiState = MutableStateFlow(ExerciseBrowserUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadExercises()
    }

    private fun loadExercises() = viewModelScope.launch {
        val exercises = exercisesRepository.getExercises()
        _uiState.update {
            it.copy(exercises = exercises)
        }
    }
}
