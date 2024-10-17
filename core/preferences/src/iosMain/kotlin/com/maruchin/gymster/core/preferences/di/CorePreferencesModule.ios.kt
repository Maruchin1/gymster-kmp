package com.maruchin.gymster.core.preferences.di

import com.maruchin.gymster.core.preferences.datastore.dataStore
import org.koin.core.qualifier.named
import org.koin.dsl.module

actual val corePreferencesModule = module {

    single(named(PLANS_PREFERENCES)) {
        dataStore(fileName = PLANS_PREFERENCES)
    }
}
