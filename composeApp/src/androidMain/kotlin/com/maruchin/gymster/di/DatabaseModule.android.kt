package com.maruchin.gymster.di

import com.maruchin.gymster.core.database.databaseBuilder
import org.koin.dsl.module

internal actual val databasePlatformModule = module {

    factory { databaseBuilder(get()) }
}
