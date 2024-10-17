package com.maruchin.gymster.core.preferences.di

import com.maruchin.gymster.core.preferences.datastore.fakeDataStore
import org.koin.core.qualifier.named
import org.koin.dsl.module

actual val corePreferencesTestModule = module {

    single(named(PLANS_PREFERENCES)) {
        fakeDataStore(storeName = PLANS_PREFERENCES)
    }
}
