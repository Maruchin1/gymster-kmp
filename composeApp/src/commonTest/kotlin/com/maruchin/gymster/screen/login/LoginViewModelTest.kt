package com.maruchin.gymster.screen.login

import app.cash.turbine.test
import com.maruchin.gymster.data.session.json.testTokenObtainPairJson
import com.maruchin.gymster.data.session.json.testTokenObtainPairJsonInvalidCredentials
import com.maruchin.gymster.data.session.model.testLoginRequest
import com.maruchin.gymster.di.testModule
import com.maruchin.gymster.test.respondJson
import io.kotest.matchers.shouldBe
import io.ktor.client.engine.mock.MockEngineConfig
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
class LoginViewModelTest : KoinTest {

    private val mockEngineConfig: MockEngineConfig by inject()
    private val viewModel: LoginViewModel by inject()

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
    fun `successful login`() = runTest {
        mockEngineConfig.addHandler {
            respondJson(testTokenObtainPairJson)
        }

        viewModel.uiState.test {
            awaitItem() shouldBe LoginUiState()

            viewModel.login(testLoginRequest)
            awaitItem() shouldBe LoginUiState(isSubmitting = true)
            awaitItem() shouldBe LoginUiState(result = LoginResult.SUCCESS)
        }
    }

    @Test
    fun `invalid credentials`() = runTest {
        mockEngineConfig.addHandler {
            respondJson(
                json = testTokenObtainPairJsonInvalidCredentials,
                status = HttpStatusCode.Unauthorized
            )
        }

        viewModel.uiState.test {
            awaitItem() shouldBe LoginUiState()

            viewModel.login(testLoginRequest)
            awaitItem() shouldBe LoginUiState(isSubmitting = true)
            awaitItem() shouldBe LoginUiState(result = LoginResult.INVALID_CREDENTIALS)
        }
    }
}
