package com.maruchin.gymster.di

import com.maruchin.gymster.data.exercises.api.ExerciseBaseInfoApi
import com.maruchin.gymster.data.plans2.api.DayApi
import com.maruchin.gymster.data.plans2.api.SetApi
import com.maruchin.gymster.data.plans2.api.SettingApi
import com.maruchin.gymster.data.plans2.api.WorkoutApi
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

internal val apiModule = module {

    factoryOf(::ExerciseBaseInfoApi)

    factoryOf(::WorkoutApi)

    factoryOf(::DayApi)

    factoryOf(::SetApi)

    factoryOf(::SettingApi)
}
