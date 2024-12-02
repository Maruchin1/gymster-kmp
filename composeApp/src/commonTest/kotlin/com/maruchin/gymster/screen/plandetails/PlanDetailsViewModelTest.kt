package com.maruchin.gymster.screen.plandetails

import app.cash.turbine.test
import com.maruchin.gymster.data.plans.json.samplePushPullWorkoutJson
import com.maruchin.gymster.data.plans.model.samplePushPullPlan
import com.maruchin.gymster.data.trainings.json.sampleEmptyDayListJson
import com.maruchin.gymster.data.trainings.json.sampleEmptySetListJson
import com.maruchin.gymster.data.trainings.json.samplePushAndPullDayListJson
import com.maruchin.gymster.data.trainings.model.sampleEmptyPullTraining
import com.maruchin.gymster.data.trainings.model.sampleEmptyPushTraining
import com.maruchin.gymster.di.testAppModules
import com.maruchin.gymster.test.respondJson
import io.kotest.matchers.shouldBe
import io.ktor.client.engine.mock.MockEngineConfig
import io.ktor.http.HttpMethod
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
import org.koin.test.inject

@OptIn(ExperimentalCoroutinesApi::class)
class PlanDetailsViewModelTest : KoinTest {

    private val mockEngineConfig: MockEngineConfig by inject()
    private val viewModel: PlanDetailsViewModel by inject { parametersOf(samplePushPullPlan.id) }

    @BeforeTest
    fun setup() {
        Dispatchers.setMain(StandardTestDispatcher())
        startKoin { modules(testAppModules) }
    }

    @AfterTest
    fun tearDown() {
        stopKoin()
        Dispatchers.resetMain()
    }

    @Test
    fun `load selected plan with no trainings`() = runTest {
        mockEngineConfig.addHandler {
            it.url.encodedPath shouldBe "/api/v2/workout/${samplePushPullPlan.id}/"
            it.method shouldBe HttpMethod.Get
            respondJson(samplePushPullWorkoutJson)
        }
        mockEngineConfig.addHandler {
            it.url.encodedPath shouldBe "/api/v2/day/"
            it.url.encodedQuery shouldBe "training=${samplePushPullPlan.id}&limit=100"
            it.method shouldBe HttpMethod.Get
            respondJson(sampleEmptyDayListJson)
        }

        viewModel.uiState.test {
            awaitItem() shouldBe PlanDetailsUiState()
            awaitItem() shouldBe PlanDetailsUiState(
                plan = samplePushPullPlan,
                isLoading = false
            )
        }
    }

    @Test
    fun `load selected plan with trainings`() = runTest {
        mockEngineConfig.addHandler {
            it.url.encodedPath shouldBe "/api/v2/workout/${samplePushPullPlan.id}/"
            it.method shouldBe HttpMethod.Get
            respondJson(samplePushPullWorkoutJson)
        }
        mockEngineConfig.addHandler {
            it.url.encodedPath shouldBe "/api/v2/day/"
            it.url.encodedQuery shouldBe "training=${samplePushPullPlan.id}&limit=100"
            it.method shouldBe HttpMethod.Get
            respondJson(samplePushAndPullDayListJson)
        }
        mockEngineConfig.addHandler {
            it.url.encodedPath shouldBe "/api/v2/set/"
            it.url.encodedQuery shouldBe "exerciseday=199701&limit=100"
            it.method shouldBe HttpMethod.Get
            respondJson(sampleEmptySetListJson)
        }
        mockEngineConfig.addHandler {
            it.url.encodedPath shouldBe "/api/v2/set/"
            it.url.encodedQuery shouldBe "exerciseday=199703&limit=100"
            it.method shouldBe HttpMethod.Get
            respondJson(sampleEmptySetListJson)
        }

        viewModel.uiState.test {
            awaitItem() shouldBe PlanDetailsUiState()
            awaitItem() shouldBe PlanDetailsUiState(
                plan = samplePushPullPlan,
                trainings = listOf(sampleEmptyPushTraining, sampleEmptyPullTraining),
                isLoading = false
            )
        }
    }
}
