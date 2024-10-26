package com.maruchin.gymster.di

import com.maruchin.gymster.core.clock.FakeClock
import com.maruchin.gymster.core.preferences.PreferencesFactory
import com.maruchin.gymster.core.preferences.PreferencesType
import kotlinx.datetime.Clock
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

internal val testCoreModule = module {

    single(named(PreferencesType.PLANS)) {
        val factory = get<PreferencesFactory>()
        val storeName = PreferencesType.PLANS.storeName
        factory.createInMemoryDataStore(storeName)
    }

    single { FakeClock() } bind Clock::class
}
