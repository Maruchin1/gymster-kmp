package com.maruchin.gymster.di

import com.maruchin.gymster.core.preferences.SessionStore
import org.koin.core.qualifier.named
import org.koin.dsl.module

internal val storeModule = module {

    factory { SessionStore(get(named<SessionStore>())) }
}
