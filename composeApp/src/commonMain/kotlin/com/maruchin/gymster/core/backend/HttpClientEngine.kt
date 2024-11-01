package com.maruchin.gymster.core.backend

import io.ktor.client.engine.HttpClientEngine

internal expect fun httpClientEngine(): HttpClientEngine
