package com.maruchin.gymster.core.ui

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
