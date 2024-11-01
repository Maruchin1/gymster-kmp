package com.maruchin.gymster.core.backend

import io.ktor.client.plugins.logging.Logger

internal fun kermitLogger() = object : Logger {
    override fun log(message: String) {
        co.touchlab.kermit.Logger.v("Ktor") { message }
    }
}
