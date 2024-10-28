package com.maruchin.gymster.di

import com.maruchin.gymster.core.preferences.PLANS_PREFERENCES
import com.maruchin.gymster.core.preferences.dataStore
import com.maruchin.gymster.core.preferences.temporaryDataStore
import org.koin.core.qualifier.named
import org.koin.dsl.module

internal actual val preferencesModule = module {

    single(named(PLANS_PREFERENCES)) {
        dataStore(PLANS_PREFERENCES)
    }
}
internal actual val testPreferencesModule = module {

    single(named(PLANS_PREFERENCES)) {
        temporaryDataStore(PLANS_PREFERENCES)
    }
}
