package com.maruchin.gymster.screen.planlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.gymster.data.plans.PlansRepository
import com.maruchin.gymster.data.plans.model.samplePlans
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

internal class PlanListViewModel(private val plansRepository: PlansRepository) : ViewModel() {

    val uiState: StateFlow<PlanListUiState> = plansRepository.observeAllPlans()
        .map { PlanListUiState(it) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = PlanListUiState()
        )

    fun createPlan(name: String) = viewModelScope.launch {
        plansRepository.createPlan(name)
    }

    fun seedPlans() = viewModelScope.launch {
        samplePlans.first().let { plan ->
            val planId = plansRepository.createPlan(plan.name)
            plan.trainings.forEach { training ->
                val trainingId = plansRepository.addTraining(
                    planId = planId,
                    name = training.name
                )
                training.exercises.forEach { exercise ->
                    plansRepository.addExercise(
                        trainingId = trainingId,
                        name = exercise.name,
                        sets = exercise.sets,
                        reps = exercise.reps
                    )
                }
            }
        }
    }
}
