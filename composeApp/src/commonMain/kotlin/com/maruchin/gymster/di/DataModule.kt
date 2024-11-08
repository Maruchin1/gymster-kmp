package com.maruchin.gymster.di

import com.maruchin.gymster.data.exercises.ExerciseCategoriesRepository
import com.maruchin.gymster.data.exercises.ExercisesRepository
import com.maruchin.gymster.data.plans.PlansRepository
import com.maruchin.gymster.data.session.SessionRepository
import com.maruchin.gymster.data.userprofile.UserProfileRepository
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

internal val dataModule = module {

    factoryOf(::ExercisesRepository)

    factoryOf(::ExerciseCategoriesRepository)

    factoryOf(::SessionRepository)

    factoryOf(::UserProfileRepository)

    factoryOf(::PlansRepository)
}
