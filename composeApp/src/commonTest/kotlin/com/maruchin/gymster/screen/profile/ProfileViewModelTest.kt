package com.maruchin.gymster.screen.profile

import app.cash.turbine.test
import com.maruchin.gymster.core.preferences.SessionStore
import com.maruchin.gymster.data.session.testdata.testLoginJson
import com.maruchin.gymster.data.userprofile.testdata.testUserProfile
import com.maruchin.gymster.data.userprofile.testdata.testUserProfileJsonRaw
import com.maruchin.gymster.di.testAppModules
import com.maruchin.gymster.test.respondJson
import io.kotest.matchers.shouldBe
import io.ktor.client.engine.mock.MockEngineConfig
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
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ProfileViewModelTest : KoinTest {

    private val mockEngineConfig: MockEngineConfig by inject()
    private val sessionStore: SessionStore by inject()
    private val viewModel: ProfileViewModel by inject()

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
    fun `emit user profile`() = runTest {
        mockEngineConfig.addHandler {
            respondJson(testUserProfileJsonRaw)
        }
        sessionStore.saveToken(testLoginJson.token)

        viewModel.uiState.test {
            awaitItem() shouldBe ProfileUiState()

            awaitItem() shouldBe ProfileUiState(isLoggedIn = true)

            awaitItem() shouldBe ProfileUiState(
                userProfile = testUserProfile,
                isLoggedIn = true,
                isLoading = false
            )
        }
    }

    @Test
    fun `logout user`() = runTest {
        mockEngineConfig.addHandler {
            respondJson(testUserProfileJsonRaw)
        }
        sessionStore.saveToken(testLoginJson.token)

        viewModel.uiState.test {
            awaitItem() shouldBe ProfileUiState()

            awaitItem() shouldBe ProfileUiState(isLoggedIn = true)

            awaitItem() shouldBe ProfileUiState(
                userProfile = testUserProfile,
                isLoggedIn = true,
                isLoading = false
            )

            viewModel.logout()

            awaitItem() shouldBe ProfileUiState(
                userProfile = testUserProfile,
                isLoggedIn = false,
                isLoading = false
            )
        }
    }
}
