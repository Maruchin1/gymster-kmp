package com.maruchin.gymster.di

import com.maruchin.gymster.core.backend.httpClientEngine
import com.maruchin.gymster.core.backend.wgerHttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.MockEngineConfig
import org.koin.dsl.module

internal val backendModule = module {

    single { wgerHttpClient(httpClientEngine()) }
}

internal val testBackendModule = module {

    single { MockEngineConfig() }

    single { wgerHttpClient(MockEngine(get())) }
}
