package com.maruchin.gymster.screen.plandetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.touchlab.kermit.Logger
import com.maruchin.gymster.data.plans.PlansRepository
import com.maruchin.gymster.data.plans.model.EditPlanRequest
import com.maruchin.gymster.data.trainings.TrainingsRepository
import com.maruchin.gymster.data.trainings.model.AddTrainingRequest
import com.maruchin.gymster.data.trainings.model.EditTrainingRequest
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class PlanDetailsViewModel(
    private val planId: Int,
    private val plansRepository: PlansRepository,
    private val trainingsRepository: TrainingsRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(PlanDetailsUiState())
    val uiState = _uiState.asStateFlow()

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Logger.e(throwable) { "Error in PlanDetailsViewModel" }
        _uiState.update {
            it.copy(isLoading = false, isError = true)
        }
    }

    init {
        loadPlanAndTrainings()
    }

    fun editPlan(request: EditPlanRequest) = viewModelScope.launch(exceptionHandler) {
        _uiState.update {
            it.copy(isLoading = true)
        }
        plansRepository.editPlan(request)
        loadPlanAndTrainings()
    }

    fun deletePlan(planId: Int) = viewModelScope.launch(exceptionHandler) {
        _uiState.update {
            it.copy(isLoading = true)
        }
        plansRepository.deletePlan(planId)
        _uiState.update {
            it.copy(isLoading = false, isDeleted = true)
        }
    }

    fun addTraining(request: AddTrainingRequest) = viewModelScope.launch(exceptionHandler) {
        _uiState.update {
            it.copy(isLoading = true)
        }
        trainingsRepository.addTraining(request)
        loadPlanAndTrainings()
    }

    fun editTraining(request: EditTrainingRequest) = viewModelScope.launch(exceptionHandler) {
        _uiState.update {
            it.copy(isLoading = true)
        }
        trainingsRepository.editTraining(request)
        loadPlanAndTrainings()
    }

    fun deleteTraining(trainingId: Int) = viewModelScope.launch(exceptionHandler) {
        _uiState.update {
            it.copy(isLoading = true)
        }
        trainingsRepository.deleteTraining(trainingId)
        loadPlanAndTrainings()
    }

    fun clearError() {
        _uiState.update {
            it.copy(isError = false)
        }
    }

    private fun loadPlanAndTrainings() = viewModelScope.launch(exceptionHandler) {
        val planAsync = async { plansRepository.getPlan(planId) }
        val trainingsAsync = async { trainingsRepository.getPlanTrainings(planId) }

        val plan = planAsync.await()
        val trainings = trainingsAsync.await()

        _uiState.update {
            it.copy(plan = plan, trainings = trainings, isLoading = false)
        }
    }
}
