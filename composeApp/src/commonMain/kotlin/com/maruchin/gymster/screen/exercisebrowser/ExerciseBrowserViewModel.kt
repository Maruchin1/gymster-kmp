package com.maruchin.gymster.screen.exercisebrowser

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.touchlab.kermit.Logger
import com.maruchin.gymster.data.exercises.ExerciseCategoriesRepository
import com.maruchin.gymster.data.exercises.ExercisesRepository
import com.maruchin.gymster.data.exercises.model.ExerciseCategory
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

// TODO Add more unit tests

internal class ExerciseBrowserViewModel(
    private val exercisesRepository: ExercisesRepository,
    private val exerciseCategoriesRepository: ExerciseCategoriesRepository
) : ViewModel() {

    var uiState by mutableStateOf(ExerciseBrowserUiState())
        private set

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Logger.e("ExerciseBrowserViewModel", throwable)
    }

    init {
        loadCategories()
        loadNextExercisePage()
    }

    fun loadNextExercisePage() = viewModelScope.launch(exceptionHandler) {
        val pageIndex = uiState.nextPageIndex
        val categoryId = uiState.selectedCategory?.id
        checkNotNull(pageIndex)
        val exercises = exercisesRepository.getExercises(pageIndex, categoryId)
        uiState = if (exercises.isNotEmpty()) {
            uiState.copy(
                exercises = uiState.exercises + exercises,
                nextPageIndex = pageIndex + 1
            )
        } else {
            uiState.copy(nextPageIndex = null)
        }
    }

    fun selectCategory(category: ExerciseCategory?) {
        uiState = uiState.copy(
            selectedCategory = category,
            nextPageIndex = 0,
            exercises = emptyList()
        )
        loadNextExercisePage()
    }

    private fun loadCategories() = viewModelScope.launch(exceptionHandler) {
        val categories = exerciseCategoriesRepository.getAllExerciseCategories()
        uiState = uiState.copy(categories = categories)
    }
}
