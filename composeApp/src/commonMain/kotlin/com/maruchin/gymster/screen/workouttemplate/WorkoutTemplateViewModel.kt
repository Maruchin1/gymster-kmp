package com.maruchin.gymster.screen.workouttemplate

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.touchlab.kermit.Logger
import com.maruchin.gymster.data.plans2.PlansRepository
import com.maruchin.gymster.data.plans2.model.RenameWorkoutTemplateRequest
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class WorkoutTemplateViewModel(
    private val workoutTemplateId: Int,
    private val plansRepository: PlansRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(WorkoutTemplateUiState())
    val uiState = _uiState.asStateFlow()

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _uiState.update { it.copy(isLoading = false, isError = true) }
        Logger.e(throwable) { throwable.message.orEmpty() }
    }

    init {
        loadWorkoutTemplate()
    }

    fun clearError() {
        _uiState.update { it.copy(isError = false) }
    }

    fun renameWorkoutTemplate(
        request: RenameWorkoutTemplateRequest
    ) = viewModelScope.launch(exceptionHandler) {
        _uiState.update { it.copy(isLoading = true) }
        plansRepository.renameWorkoutTemplate(request)
        loadWorkoutTemplate()
    }

    private fun loadWorkoutTemplate() = viewModelScope.launch(exceptionHandler) {
        val workoutTemplate = plansRepository.getWorkoutTemplateById(workoutTemplateId)
        _uiState.update {
            it.copy(workoutTemplate = workoutTemplate, isLoading = false)
        }
    }
}
