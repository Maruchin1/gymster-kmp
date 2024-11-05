package com.maruchin.gymster.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maruchin.gymster.data.plans.PlansRepository
import com.maruchin.gymster.data.session.SessionRepository
import com.maruchin.gymster.data.trainings.TrainingsRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

internal class HomeViewModel(
    private val sessionRepository: SessionRepository,
    private val plansRepository: PlansRepository,
    private val trainingsRepository: TrainingsRepository
) : ViewModel() {

    val uiState: StateFlow<HomeUiState> = combine(
        sessionRepository.observeSession(),
        plansRepository.observeActivePlan(),
        trainingsRepository.observeCurrentTrainingWeek(),
        ::HomeUiState
    ).stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = HomeUiState()
    )

    fun startNewWeek() = viewModelScope.launch {
        val activePlan = plansRepository.observeActivePlan().first()
        checkNotNull(activePlan)
        trainingsRepository.startNewWeek(activePlan)
    }
}
