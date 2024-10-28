package com.maruchin.gymster.screen.home

import app.cash.turbine.test
import com.maruchin.gymster.data.plans.PlansRepository
import com.maruchin.gymster.data.trainings.TrainingsRepository
import com.maruchin.gymster.di.testModule
import io.kotest.matchers.shouldBe
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject

@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModelTest : KoinTest {

    private val plansRepository: PlansRepository by inject()
    private val trainingsRepository: TrainingsRepository by inject()
    private val viewModel: HomeViewModel by inject()

    @BeforeTest
    fun setup() {
        Dispatchers.setMain(StandardTestDispatcher())
        startKoin { modules(testModule) }
    }

    @AfterTest
    fun tearDown() {
        stopKoin()
        Dispatchers.resetMain()
    }

    @Test
    fun `emit no active plan`() = runTest {
        viewModel.uiState.test {
            awaitItem() shouldBe HomeUiState()
        }
    }

    @Test
    fun `emit active plan`() = runTest {
        val planId = plansRepository.createPlan(name = "Push Pull")
        plansRepository.setActivePlan(planId)

        viewModel.uiState.test {
            awaitItem() shouldBe HomeUiState()
        }
    }
}
