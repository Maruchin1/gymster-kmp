package com.maruchin.gymster.screen.planlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.touchlab.kermit.Logger
import com.maruchin.gymster.data.plans.PlansRepository
import com.maruchin.gymster.data.plans.model.AddPlanRequest
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class PlanListViewModel(private val plansRepository: PlansRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(PlanListUiState())
    val uiState = _uiState
        .onStart { loadPlans() }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = PlanListUiState()
        )

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Logger.e(throwable) { "Error in PlanListViewModel" }
        _uiState.update {
            it.copy(isLoading = false, isError = true)
        }
    }

    fun addPlan(request: AddPlanRequest) = viewModelScope.launch(exceptionHandler) {
        _uiState.update {
            it.copy(isLoading = true)
        }
        plansRepository.addPlan(request)
        loadPlans()
    }

    fun clearError() {
        _uiState.update {
            it.copy(isError = false)
        }
    }

    private fun loadPlans() = viewModelScope.launch(exceptionHandler) {
        _uiState.update {
            it.copy(isLoading = true)
        }
        val plans = plansRepository.getAllPlans()
        _uiState.update {
            it.copy(plans = plans, isLoading = false)
        }
    }
}
