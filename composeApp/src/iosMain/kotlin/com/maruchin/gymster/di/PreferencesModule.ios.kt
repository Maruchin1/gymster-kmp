package com.maruchin.gymster.di

import com.maruchin.gymster.core.preferences.PLANS_PREFERENCES
import com.maruchin.gymster.core.preferences.SessionPreferences
import com.maruchin.gymster.core.preferences.dataStore
import com.maruchin.gymster.core.preferences.temporaryDataStore
import org.koin.core.qualifier.named
import org.koin.dsl.module

internal actual val preferencesModule = module {

    single(named(PLANS_PREFERENCES)) {
        dataStore(PLANS_PREFERENCES)
    }

    single(named<SessionPreferences>()) {
        dataStore(SessionPreferences.NAME)
    }
}
internal actual val testPreferencesModule = module {

    single(named(PLANS_PREFERENCES)) {
        temporaryDataStore(PLANS_PREFERENCES)
    }

    single(named<SessionPreferences>()) {
        temporaryDataStore(SessionPreferences.NAME)
    }
}
