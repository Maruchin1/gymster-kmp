package com.maruchin.gymster.feature.trainings.history

import app.cash.turbine.test
import com.maruchin.gymster.data.trainings.di.dataTrainingsTestModule
import com.maruchin.gymster.data.trainings.model.sampleTrainingWeeks
import com.maruchin.gymster.data.trainings.repository.FakeTrainingsRepository
import com.maruchin.gymster.feature.trainings.di.featureTrainingsModule
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
class TrainingHistoryViewModelTest : KoinTest {

    private val trainingsRepository: FakeTrainingsRepository by inject()
    private val viewModel: TrainingHistoryViewModel by inject()

    @BeforeTest
    fun setup() {
        Dispatchers.setMain(StandardTestDispatcher())
        startKoin { modules(featureTrainingsModule, dataTrainingsTestModule) }
    }

    @AfterTest
    fun tearDown() {
        stopKoin()
        Dispatchers.resetMain()
    }

    @Test
    fun `emit training weeks list`() = runTest {
        trainingsRepository.setTrainingWeeks(sampleTrainingWeeks)

        viewModel.uiState.test {
            awaitItem() shouldBe TrainingHistoryUiState()

            awaitItem() shouldBe TrainingHistoryUiState(sampleTrainingWeeks)
        }
    }
}
