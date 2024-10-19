package com.maruchin.gymster.core.utils.di

import com.maruchin.gymster.core.utils.clock.FakeClock
import kotlinx.datetime.Clock
import org.koin.dsl.bind
import org.koin.dsl.module

val coreClockTestModule = module {

    single { FakeClock() } bind Clock::class
}
