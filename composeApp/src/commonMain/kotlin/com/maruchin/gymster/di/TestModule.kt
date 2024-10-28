package com.maruchin.gymster.di

import org.koin.dsl.module

internal val testModule = module {
    includes(uiModule, dataModule, testClockModule, testDatabaseModule, testPreferencesModule)
}
