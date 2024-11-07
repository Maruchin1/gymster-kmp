package com.maruchin.gymster.di

internal val appModules = listOf(
    screenModule,
    dataModule,
    storeModule,
    clockModule,
    dataStoreModule,
    backendModule
)

internal val testAppModules = listOf(
    screenModule,
    dataModule,
    storeModule,
    testClockModule,
    testDataStoreModule,
    testBackendModule
)
