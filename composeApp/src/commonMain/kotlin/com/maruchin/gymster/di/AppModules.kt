package com.maruchin.gymster.di

internal val appModules = listOf(
    screenModule,
    dataModule,
    apiModule,
    storeModule,
    clockModule,
    dataStoreModule,
    backendModule
)

internal val testAppModules = listOf(
    screenModule,
    dataModule,
    apiModule,
    storeModule,
    testClockModule,
    testDataStoreModule,
    testBackendModule
)
