package com.maruchin.gymster.feature.home

import app.cash.turbine.test
import com.maruchin.gymster.core.utils.di.coreClockTestModule
import com.maruchin.gymster.data.plans.di.dataPlansTestModule
import com.maruchin.gymster.data.plans.model.samplePlans
import com.maruchin.gymster.data.plans.model.samplePushPullLegsPlan
import com.maruchin.gymster.data.plans.model.samplePushPullLegsPlanActive
import com.maruchin.gymster.data.plans.repository.FakePlansRepository
import com.maruchin.gymster.data.trainings.di.dataTrainingsTestModule
import com.maruchin.gymster.data.trainings.model.samplePushPullLegsTrainingWeek
import com.maruchin.gymster.data.trainings.model.sampleTrainingWeeks
import com.maruchin.gymster.data.trainings.repository.FakeTrainingsRepository
import com.maruchin.gymster.feature.home.di.featureHomeModule
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

    private val plansRepository: FakePlansRepository by inject()
    private val trainingsRepository: FakeTrainingsRepository by inject()
    private val viewModel: HomeViewModel by inject()

    @BeforeTest
    fun setup() {
        Dispatchers.setMain(StandardTestDispatcher())
        startKoin {
            modules(
                featureHomeModule,
                dataPlansTestModule,
                dataTrainingsTestModule,
                coreClockTestModule
            )
        }
    }

    @AfterTest
    fun tearDown() {
        stopKoin()
        Dispatchers.resetMain()
    }

    @Test
    fun `emit active plan and current week`() = runTest {
        plansRepository.setPlans(samplePlans)
        plansRepository.setActivePlan(samplePushPullLegsPlan.id)
        trainingsRepository.setTrainingWeeks(sampleTrainingWeeks)

        viewModel.uiState.test {
            awaitItem() shouldBe HomeUiState()

            awaitItem() shouldBe HomeUiState(
                activePlan = samplePushPullLegsPlanActive,
                currentTrainingWeek = samplePushPullLegsTrainingWeek
            )
        }
    }
}
