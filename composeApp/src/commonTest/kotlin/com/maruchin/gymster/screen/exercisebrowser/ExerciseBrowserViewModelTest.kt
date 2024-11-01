package com.maruchin.gymster.screen.exercisebrowser

import app.cash.turbine.test
import com.maruchin.gymster.data.exercises.json.samplePaginatedExerciseBaseInfoListJson
import com.maruchin.gymster.data.exercises.model.sampleExercises
import com.maruchin.gymster.di.testModule
import com.maruchin.gymster.test.respondJson
import io.kotest.matchers.shouldBe
import io.ktor.client.engine.mock.MockEngineConfig
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
class ExerciseBrowserViewModelTest : KoinTest {

    private val mockEngineConfig: MockEngineConfig by inject()
    private val viewModel: ExerciseBrowserViewModel by inject()

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
    fun `emit exercises`() = runTest {
        mockEngineConfig.addHandler {
            respondJson(samplePaginatedExerciseBaseInfoListJson)
        }

        viewModel.uiState.test {
            awaitItem() shouldBe ExerciseBrowserUiState()

            awaitItem() shouldBe ExerciseBrowserUiState(exercises = sampleExercises)
        }
    }
}
