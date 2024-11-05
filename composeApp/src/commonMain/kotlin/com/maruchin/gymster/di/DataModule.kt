package com.maruchin.gymster.di

import com.maruchin.gymster.core.preferences.SessionPreferences
import com.maruchin.gymster.data.exercises.ExerciseCategoriesRepository
import com.maruchin.gymster.data.exercises.ExercisesRepository
import com.maruchin.gymster.data.session.SessionRepository
import org.koin.core.module.dsl.factoryOf
import org.koin.core.qualifier.named
import org.koin.dsl.module

internal val dataModule = module {

    factoryOf(::ExercisesRepository)

    factoryOf(::ExerciseCategoriesRepository)

    factory { SessionRepository(get(), get(named<SessionPreferences>())) }
}
