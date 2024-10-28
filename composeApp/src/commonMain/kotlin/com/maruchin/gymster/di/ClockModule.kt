package com.maruchin.gymster.di

import com.maruchin.gymster.core.clock.FakeClock
import kotlinx.datetime.Clock
import org.koin.dsl.bind
import org.koin.dsl.module

internal val clockModule = module {

    factory { Clock.System } bind Clock::class
}

internal val testClockModule = module {

    single { FakeClock() } bind Clock::class
}
