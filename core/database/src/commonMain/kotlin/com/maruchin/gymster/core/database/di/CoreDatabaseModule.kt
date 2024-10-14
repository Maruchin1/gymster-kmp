package com.maruchin.gymster.core.database.di

import com.maruchin.gymster.core.database.room.GymsterDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

val coreDatabaseModule = module {

    includes(platformModule)

    single { GymsterDatabase.create(get()) }

    factory { get<GymsterDatabase>().planDao }

    factory { get<GymsterDatabase>().planTrainingDao }

    factory { get<GymsterDatabase>().planExerciseDao }
}

internal expect val platformModule: Module
