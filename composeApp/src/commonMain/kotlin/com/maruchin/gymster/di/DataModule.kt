package com.maruchin.gymster.di

import com.maruchin.gymster.core.preferences.PreferencesType
import com.maruchin.gymster.data.plans.DefaultPlansRepository
import com.maruchin.gymster.data.plans.PlansRepository
import com.maruchin.gymster.data.plans.datasource.PlansLocalDataSource
import com.maruchin.gymster.data.plans.datasource.PlansPreferencesDataSource
import com.maruchin.gymster.data.trainings.DefaultTrainingsRepository
import com.maruchin.gymster.data.trainings.TrainingsRepository
import org.koin.core.module.dsl.factoryOf
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

internal val dataModule = module {

    factoryOf(::PlansLocalDataSource)

    factory { PlansPreferencesDataSource(get(named(PreferencesType.PLANS))) }

    factoryOf(::DefaultPlansRepository) bind PlansRepository::class

    factoryOf(::DefaultTrainingsRepository) bind TrainingsRepository::class
}
