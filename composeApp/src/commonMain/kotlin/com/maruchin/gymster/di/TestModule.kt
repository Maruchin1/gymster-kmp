package com.maruchin.gymster.di

import org.koin.dsl.module

internal val testModule = module {
    includes(
        screenModule,
        dataModule,
        testClockModule,
        testDatabaseModule,
        testPreferencesModule,
        testBackendModule
    )
}
