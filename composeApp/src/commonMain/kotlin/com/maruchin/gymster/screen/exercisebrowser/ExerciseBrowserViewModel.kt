package com.maruchin.gymster.screen.exercisebrowser

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.touchlab.kermit.Logger
import com.maruchin.gymster.data.exercises.ExercisesRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

// TODO Add more unit tests

internal class ExerciseBrowserViewModel(private val exercisesRepository: ExercisesRepository) :
    ViewModel() {

    private val _uiState = MutableStateFlow(ExerciseBrowserUiState())
    val uiState = _uiState.asStateFlow()

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Logger.e("ExerciseBrowserViewModel", throwable)
    }

    init {
        loadNextExercisePage()
    }

    fun loadNextExercisePage() = viewModelScope.launch(exceptionHandler) {
        val nextPageIndex = uiState.value.nextPageIndex
        checkNotNull(nextPageIndex)
        val exercises = exercisesRepository.getExercises(nextPageIndex)
        if (exercises.isNotEmpty()) {
            _uiState.update {
                it.copy(exercises = it.exercises + exercises, nextPageIndex = nextPageIndex + 1)
            }
        } else {
            _uiState.update {
                it.copy(nextPageIndex = null)
            }
        }
    }
}
