package com.maruchin.gymster.screen.plandetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.touchlab.kermit.Logger
import com.maruchin.gymster.data.plans.PlansRepository
import com.maruchin.gymster.data.plans.model.EditPlanRequest
import com.maruchin.gymster.data.trainings.TrainingsRepository
import com.maruchin.gymster.data.trainings.model.AddExerciseRequest
import com.maruchin.gymster.data.trainings.model.AddSetRequest
import com.maruchin.gymster.data.trainings.model.AddTrainingRequest
import com.maruchin.gymster.data.trainings.model.EditSetRequest
import com.maruchin.gymster.data.trainings.model.EditTrainingRequest
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@Suppress("TooManyFunctions")
internal class PlanDetailsViewModel(
    private val planId: Int,
    private val plansRepository: PlansRepository,
    private val trainingsRepository: TrainingsRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(PlanDetailsUiState())
    val uiState = _uiState.asStateFlow()

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Logger.e(throwable) { throwable.message.orEmpty() }
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

    fun addExercise(request: AddExerciseRequest) = viewModelScope.launch(exceptionHandler) {
        _uiState.update {
            it.copy(isLoading = true)
        }
        trainingsRepository.addExercise(request)
        loadPlanAndTrainings()
    }

    fun addSet(request: AddSetRequest) = viewModelScope.launch(exceptionHandler) {
        _uiState.update {
            it.copy(isLoading = true)
        }
        trainingsRepository.addSet(request)
        loadPlanAndTrainings()
    }

    fun editSet(request: EditSetRequest) = viewModelScope.launch(exceptionHandler) {
        _uiState.update {
            it.copy(isLoading = true)
        }
        trainingsRepository.editSet(request)
        loadPlanAndTrainings()
    }

    fun deleteSet(setId: Int) = viewModelScope.launch(exceptionHandler) {
        _uiState.update {
            it.copy(isLoading = true)
        }
        trainingsRepository.deleteSet(setId)
        loadPlanAndTrainings()
    }

    fun clearError() {
        _uiState.update {
            it.copy(isError = false)
        }
    }

    private fun loadPlanAndTrainings() = viewModelScope.launch(exceptionHandler) {
        val plan = plansRepository.getPlan(planId)
        val trainings = trainingsRepository.getTrainings(planId)

        _uiState.update {
            it.copy(plan = plan, trainings = trainings, isLoading = false)
        }
    }
}
