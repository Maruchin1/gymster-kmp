package com.maruchin.gymster.di

import com.maruchin.gymster.data.trainings.api.DayApi
import com.maruchin.gymster.data.trainings.api.ExerciseApi
import com.maruchin.gymster.data.trainings.api.SetApi
import com.maruchin.gymster.data.trainings.api.SettingApi
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

internal val apiModule = module {

    factoryOf(::DayApi)

    factoryOf(::SetApi)

    factoryOf(::SettingApi)

    factoryOf(::ExerciseApi)
}
