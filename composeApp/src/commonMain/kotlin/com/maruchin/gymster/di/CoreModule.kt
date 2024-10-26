package com.maruchin.gymster.di

import com.maruchin.gymster.core.preferences.PreferencesFactory
import com.maruchin.gymster.core.preferences.PreferencesType
import org.koin.core.qualifier.named
import org.koin.dsl.module

internal val coreModule = module {

    single(named(PreferencesType.PLANS)) {
        val factory = get<PreferencesFactory>()
        val storeName = PreferencesType.PLANS.storeName
        factory.createDataStore(storeName)
    }
}
