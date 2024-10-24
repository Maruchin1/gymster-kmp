package com.maruchin.gymster.feature.plans.plandetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.gymster.data.plans.repository.PlansRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

internal class PlanDetailsViewModel(
    private val planId: String,
    private val plansRepository: PlansRepository
) : ViewModel() {

    private val isDeleted = MutableStateFlow(false)
    private val notification = MutableStateFlow<PlanDetailsNotification?>(null)

    val uiState: StateFlow<PlanDetailsUiState> = combine(
        plansRepository.observePlan(planId),
        isDeleted,
        notification,
        ::PlanDetailsUiState
    ).stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = PlanDetailsUiState()
    )

    fun changePlanName(name: String) = viewModelScope.launch {
        plansRepository.updatePlan(planId = planId, name = name)
    }

    fun deletePlan() = viewModelScope.launch {
        plansRepository.deletePlan(planId = planId)
        isDeleted.value = true
    }

    fun addTraining(name: String) = viewModelScope.launch {
        plansRepository.addTraining(planId = planId, name = name)
    }

    fun updateTraining(trainingId: String, name: String) = viewModelScope.launch {
        plansRepository.updateTraining(trainingId = trainingId, name = name)
    }

    fun deleteTraining(trainingId: String) = viewModelScope.launch {
        plansRepository.deleteTraining(trainingId = trainingId)
    }

    fun addExercise(trainingId: String, name: String, sets: Int, reps: IntRange) =
        viewModelScope.launch {
            plansRepository.addExercise(
                trainingId = trainingId,
                name = name,
                sets = sets,
                reps = reps
            )
        }

    fun updateExercise(exerciseId: String, name: String, sets: Int, reps: IntRange) =
        viewModelScope.launch {
            plansRepository.updateExercise(
                exerciseId = exerciseId,
                name = name,
                sets = sets,
                reps = reps
            )
        }

    fun deleteExercise(exerciseId: String) = viewModelScope.launch {
        plansRepository.deleteExercise(exerciseId)
    }

    fun reorderExercises(exercisesIds: List<String>) = viewModelScope.launch {
        plansRepository.reorderExercises(exercisesIds)
    }

    fun activatePlan() = viewModelScope.launch {
        plansRepository.setActivePlan(planId)
        notification.value = PlanDetailsNotification.PLAN_ACTIVATED
    }

    fun deactivatePlan() = viewModelScope.launch {
        plansRepository.clearActivePlan()
        notification.value = PlanDetailsNotification.PLAN_DEACTIVATED
    }

    fun clearNotification() {
        notification.value = null
    }
}
