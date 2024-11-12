package com.maruchin.gymster.screen.exercisebrowser

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.touchlab.kermit.Logger
import com.maruchin.gymster.data.exercises.ExerciseCategoriesRepository
import com.maruchin.gymster.data.exercises.ExercisesRepository
import com.maruchin.gymster.data.exercises.model.ExerciseCategory
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

// TODO Add more unit tests

internal class ExerciseBrowserViewModel(
    private val exercisesRepository: ExercisesRepository,
    private val exerciseCategoriesRepository: ExerciseCategoriesRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(ExerciseBrowserUiState())
    val uiState = _uiState.asStateFlow()

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Logger.e(throwable) { "Error in ExerciseBrowserViewModel" }
        _uiState.update {
            it.copy(status = ExerciseBrowserStatus.ERROR)
        }
    }

    init {
        loadData()
    }

    fun searchExercises(term: String) {
        _uiState.update {
            it.copy(searchTerm = term)
        }
    }

    fun selectCategory(category: ExerciseCategory?) = viewModelScope.launch(exceptionHandler) {
        _uiState.update {
            it.copy(selectedCategory = category)
        }
    }

    fun resetStatus() {
        _uiState.update {
            it.copy(status = ExerciseBrowserStatus.IDLE)
        }
    }

    private fun loadData() = viewModelScope.launch(exceptionHandler) {
        val categoriesAsync = async { exerciseCategoriesRepository.getAllExerciseCategories() }
        val exercisesAsync = async { exercisesRepository.getAllExercises() }
        val categories = categoriesAsync.await()
        val exercises = exercisesAsync.await()

        _uiState.update {
            it.copy(
                categories = categories,
                exercises = exercises,
                status = ExerciseBrowserStatus.IDLE
            )
        }
    }
}
