package com.maruchin.gymster.di

import com.maruchin.gymster.core.preferences.PreferencesFactory
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

internal actual val platformModule = module {

    factoryOf(::PreferencesFactory)
}
