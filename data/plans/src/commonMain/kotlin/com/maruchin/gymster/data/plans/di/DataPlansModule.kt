package com.maruchin.gymster.data.plans.di

import com.maruchin.gymster.core.preferences.di.PLANS_PREFERENCES
import com.maruchin.gymster.data.plans.datasource.PlansLocalDataSource
import com.maruchin.gymster.data.plans.datasource.PlansPreferencesDataSource
import com.maruchin.gymster.data.plans.repository.DefaultPlansRepository
import com.maruchin.gymster.data.plans.repository.PlansRepository
import org.koin.core.module.dsl.factoryOf
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

val dataPlansModule = module {

    factoryOf(::PlansLocalDataSource)

    factory { PlansPreferencesDataSource(get(named(PLANS_PREFERENCES))) }

    factoryOf(::DefaultPlansRepository) bind PlansRepository::class
}
