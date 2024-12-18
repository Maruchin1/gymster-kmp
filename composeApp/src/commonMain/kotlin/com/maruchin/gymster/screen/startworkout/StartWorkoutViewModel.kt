package com.maruchin.gymster.screen.startworkout

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.touchlab.kermit.Logger
import com.maruchin.gymster.data.plans2.PlansRepository
import com.maruchin.gymster.data.plans2.model.AddPlanRequest
import com.maruchin.gymster.data.plans2.model.AddWorkoutTemplateRequest
import com.maruchin.gymster.data.plans2.model.RenamePlanRequest
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class StartWorkoutViewModel(
    private val plansRepository: PlansRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(StartWorkoutUiState())
    val uiState = _uiState.asStateFlow()

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Logger.e(throwable) { "Failure in StartWorkoutViewModel" }
        _uiState.update { it.copy(isLoading = false, isFailure = true) }
    }

    init {
        loadPlans()
    }

    fun clearFailure() {
        _uiState.update { it.copy(isFailure = false) }
    }

    fun refresh() {
        _uiState.update { it.copy(isLoading = true) }
        loadPlans()
    }

    fun addPlan(request: AddPlanRequest) = viewModelScope.launch(exceptionHandler) {
        _uiState.update { it.copy(isLoading = true) }
        plansRepository.addPlan(request)
        loadPlans()
    }

    fun renamePlan(request: RenamePlanRequest) = viewModelScope.launch(exceptionHandler) {
        _uiState.update { it.copy(isLoading = true) }
        plansRepository.renamePlan(request)
        loadPlans()
    }

    fun deletePlan(planId: Int) = viewModelScope.launch(exceptionHandler) {
        _uiState.update { it.copy(isLoading = true) }
        plansRepository.deletePlan(planId)
        loadPlans()
    }

    fun addWorkout(request: AddWorkoutTemplateRequest) = viewModelScope.launch(exceptionHandler) {
        _uiState.update { it.copy(isLoading = true) }
        plansRepository.addWorkoutTemplate(request)
        loadPlans()
    }

    private fun loadPlans() = viewModelScope.launch(exceptionHandler) {
        val plans = plansRepository.getAllPlans()
        _uiState.update {
            it.copy(plans = plans, isLoading = false)
        }
    }
}
