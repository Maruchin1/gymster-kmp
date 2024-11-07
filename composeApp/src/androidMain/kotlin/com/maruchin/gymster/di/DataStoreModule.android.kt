package com.maruchin.gymster.di

import com.maruchin.gymster.core.preferences.SessionStore
import com.maruchin.gymster.core.preferences.dataStore
import com.maruchin.gymster.core.preferences.temporaryDataStore
import org.koin.core.qualifier.named
import org.koin.dsl.module

internal actual val dataStoreModule = module {

    single(named<SessionStore>()) {
        dataStore(SessionStore.NAME, get())
    }
}
internal actual val testDataStoreModule = module {

    single(named<SessionStore>()) {
        temporaryDataStore(SessionStore.NAME)
    }
}
