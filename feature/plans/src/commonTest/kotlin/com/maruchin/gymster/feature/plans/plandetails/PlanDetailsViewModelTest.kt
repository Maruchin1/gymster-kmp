package com.maruchin.gymster.feature.plans.plandetails

import app.cash.turbine.test
import com.maruchin.gymster.data.plans.di.dataPlansTestModule
import com.maruchin.gymster.data.plans.model.samplePlans
import com.maruchin.gymster.data.plans.model.samplePushPullLegsPlan
import com.maruchin.gymster.data.plans.model.samplePushPullLegsPlanActive
import com.maruchin.gymster.data.plans.repository.FakePlansRepository
import com.maruchin.gymster.feature.plans.di.featurePlansModule
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldContainInOrder
import io.kotest.matchers.collections.shouldNotContain
import io.kotest.matchers.nulls.shouldBeNull
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
import org.koin.core.parameter.parametersOf
import org.koin.test.KoinTest
import org.koin.test.get
import org.koin.test.inject

@OptIn(ExperimentalCoroutinesApi::class)
class PlanDetailsViewModelTest : KoinTest {

    private val plansRepository: FakePlansRepository by inject()

    @BeforeTest
    fun setUp() {
        startKoin { modules(featurePlansModule, dataPlansTestModule) }
        Dispatchers.setMain(StandardTestDispatcher())
    }

    @AfterTest
    fun tearDown() {
        stopKoin()
        Dispatchers.resetMain()
    }

    @Test
    fun `emit loaded state when plan is available`() = runTest {
        plansRepository.setPlans(samplePlans)
        val plan = samplePlans.random()
        val viewModel: PlanDetailsViewModel = get { parametersOf(plan.id) }

        viewModel.uiState.test {
            awaitItem() shouldBe PlanDetailsUiState()

            awaitItem() shouldBe PlanDetailsUiState(plan)
        }
    }

    @Test
    fun `do not emit new state when plan is not available`() = runTest {
        plansRepository.setPlans(samplePlans)
        val planId = "xyz"
        val viewModel: PlanDetailsViewModel = get { parametersOf(planId) }

        viewModel.uiState.test {
            awaitItem() shouldBe PlanDetailsUiState()

            expectNoEvents()
        }
    }

    @Test
    fun `delete plan`() = runTest {
        plansRepository.setPlans(samplePlans)
        val plan = samplePlans.random()
        val viewModel: PlanDetailsViewModel = get { parametersOf(plan.id) }

        viewModel.uiState.test {
            awaitItem() shouldBe PlanDetailsUiState()
            awaitItem() shouldBe PlanDetailsUiState(plan)

            viewModel.deletePlan()

            awaitItem() shouldBe PlanDetailsUiState(isDeleted = true)
        }
        plansRepository.observePlan(planId = plan.id).test {
            awaitItem().shouldBeNull()
        }
    }

    @Test
    fun `delete training`() = runTest {
        plansRepository.setPlans(samplePlans)
        val plan = samplePlans.first()
        val training = plan.trainings.random()
        val viewModel: PlanDetailsViewModel = get { parametersOf(plan.id) }

        plansRepository.observePlan(planId = plan.id).test {
            awaitItem()!!.trainings shouldContain training

            viewModel.deleteTraining(training.id)

            awaitItem()!!.trainings shouldNotContain training
        }
    }

    @Test
    fun `delete exercise`() = runTest {
        plansRepository.setPlans(samplePlans)
        val plan = samplePlans.first()
        val training = plan.trainings.first()
        val exercise = training.exercises.random()
        val viewModel: PlanDetailsViewModel = get { parametersOf(plan.id) }

        plansRepository.observePlan(planId = plan.id).test {
            awaitItem()!!.trainings.first().exercises shouldContain exercise

            viewModel.deleteExercise(exercise.id)

            awaitItem()!!.trainings.first().exercises shouldNotContain exercise
        }
    }

    @Test
    fun `reorder exercises`() = runTest {
        plansRepository.setPlans(samplePlans)
        val plan = samplePlans.first()
        val training = plan.trainings.first()
        val originalExercises = training.exercises
        val reorderedExercises = training.exercises.shuffled()
        val viewModel: PlanDetailsViewModel = get { parametersOf(plan.id) }

        plansRepository.observePlan(planId = plan.id).test {
            awaitItem()!!.trainings.first().exercises shouldContainInOrder originalExercises

            viewModel.reorderExercises(reorderedExercises.map { it.id })

            awaitItem()!!.trainings.first().exercises shouldContainInOrder reorderedExercises
        }
    }

    @Test
    fun `activate plan`() = runTest {
        plansRepository.setPlans(samplePlans)
        val viewModel: PlanDetailsViewModel = get { parametersOf(samplePushPullLegsPlan.id) }

        viewModel.uiState.test {
            awaitItem() shouldBe PlanDetailsUiState()
            awaitItem() shouldBe PlanDetailsUiState(samplePushPullLegsPlan)

            viewModel.activatePlan()
            awaitItem() shouldBe PlanDetailsUiState(
                plan = samplePushPullLegsPlanActive,
                notification = PlanDetailsNotification.PLAN_ACTIVATED
            )

            viewModel.clearNotification()
            awaitItem() shouldBe PlanDetailsUiState(samplePushPullLegsPlanActive)
        }
    }

    @Test
    fun `deactivate plan`() = runTest {
        plansRepository.setPlans(samplePlans)
        val viewModel: PlanDetailsViewModel = get { parametersOf(samplePushPullLegsPlanActive.id) }

        viewModel.uiState.test {
            awaitItem() shouldBe PlanDetailsUiState()
            awaitItem() shouldBe PlanDetailsUiState(samplePushPullLegsPlan)

            viewModel.activatePlan()
            awaitItem() shouldBe PlanDetailsUiState(
                plan = samplePushPullLegsPlanActive,
                notification = PlanDetailsNotification.PLAN_ACTIVATED
            )

            viewModel.clearNotification()
            awaitItem() shouldBe PlanDetailsUiState(samplePushPullLegsPlanActive)

            viewModel.deactivatePlan()
            awaitItem() shouldBe PlanDetailsUiState(
                plan = samplePushPullLegsPlan,
                notification = PlanDetailsNotification.PLAN_DEACTIVATED
            )

            viewModel.clearNotification()
            awaitItem() shouldBe PlanDetailsUiState(samplePushPullLegsPlan)
        }
    }
}
