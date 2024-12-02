package com.maruchin.gymster.screen.planlist

import app.cash.turbine.test
import com.maruchin.gymster.data.plans.json.sampleEmptyWorkoutListJson
import com.maruchin.gymster.data.plans.json.sampleOnePlanWorkoutListJson
import com.maruchin.gymster.data.plans.json.samplePushPullWorkoutJson
import com.maruchin.gymster.data.plans.model.samplePushPullAddPlanRequest
import com.maruchin.gymster.data.plans.model.samplePushPullPlan
import com.maruchin.gymster.di.testAppModules
import com.maruchin.gymster.test.respondJson
import io.kotest.matchers.shouldBe
import io.ktor.client.engine.mock.MockEngineConfig
import io.ktor.client.engine.mock.respondError
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
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
class PlanListViewModelTest : KoinTest {

    private val mockEngineConfig: MockEngineConfig by inject()
    private val viewModel: PlanListViewModel by inject()

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
    fun `load empty plan list`() = runTest {
        mockEngineConfig.addHandler {
            it.url.encodedPath shouldBe "/api/v2/workout/"
            it.method shouldBe HttpMethod.Get
            respondJson(sampleEmptyWorkoutListJson)
        }

        viewModel.uiState.test {
            awaitItem() shouldBe PlanListUiState()
            awaitItem() shouldBe PlanListUiState(isLoading = false)
        }
    }

    @Test
    fun `load plan list`() = runTest {
        mockEngineConfig.addHandler {
            it.url.encodedPath shouldBe "/api/v2/workout/"
            it.method shouldBe HttpMethod.Get
            respondJson(sampleOnePlanWorkoutListJson)
        }

        viewModel.uiState.test {
            awaitItem() shouldBe PlanListUiState()
            awaitItem() shouldBe PlanListUiState(
                plans = listOf(samplePushPullPlan),
                isLoading = false
            )
        }
    }

    @Test
    fun `failed to load plans`() = runTest {
        mockEngineConfig.addHandler {
            it.url.encodedPath shouldBe "/api/v2/workout/"
            it.method shouldBe HttpMethod.Get
            respondError(status = HttpStatusCode.InternalServerError)
        }

        viewModel.uiState.test {
            awaitItem() shouldBe PlanListUiState()
            awaitItem() shouldBe PlanListUiState(isLoading = false, isError = true)

            viewModel.clearError()
            awaitItem() shouldBe PlanListUiState(isLoading = false)
        }
    }

    @Test
    fun `add plan`() = runTest {
        mockEngineConfig.addHandler {
            it.url.encodedPath shouldBe "/api/v2/workout/"
            it.method shouldBe HttpMethod.Get
            respondJson(sampleEmptyWorkoutListJson)
        }
        mockEngineConfig.addHandler {
            it.url.encodedPath shouldBe "/api/v2/workout/"
            it.method shouldBe HttpMethod.Post
            // TODO Find out how to assert request body
            respondJson(samplePushPullWorkoutJson)
        }
        mockEngineConfig.addHandler {
            it.url.encodedPath shouldBe "/api/v2/workout/"
            it.method shouldBe HttpMethod.Get
            respondJson(sampleOnePlanWorkoutListJson)
        }

        viewModel.uiState.test {
            awaitItem() shouldBe PlanListUiState()
            awaitItem() shouldBe PlanListUiState(isLoading = false)

            viewModel.addPlan(samplePushPullAddPlanRequest)
            awaitItem() shouldBe PlanListUiState(isLoading = true)
            awaitItem() shouldBe PlanListUiState(
                plans = listOf(samplePushPullPlan),
                isLoading = false
            )
        }
    }

    @Test
    fun `add plan failure`() = runTest {
        mockEngineConfig.addHandler {
            it.url.encodedPath shouldBe "/api/v2/workout/"
            it.method shouldBe HttpMethod.Get
            respondJson(sampleEmptyWorkoutListJson)
        }
        mockEngineConfig.addHandler {
            it.url.encodedPath shouldBe "/api/v2/workout/"
            it.method shouldBe HttpMethod.Post
            respondError(status = HttpStatusCode.InternalServerError)
        }

        viewModel.uiState.test {
            awaitItem() shouldBe PlanListUiState()
            awaitItem() shouldBe PlanListUiState(isLoading = false)

            viewModel.addPlan(samplePushPullAddPlanRequest)
            awaitItem() shouldBe PlanListUiState(isLoading = true)
            awaitItem() shouldBe PlanListUiState(isLoading = false, isError = true)
        }
    }
}
