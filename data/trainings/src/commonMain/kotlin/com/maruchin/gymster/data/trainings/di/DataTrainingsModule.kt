package com.maruchin.gymster.data.trainings.di

import com.maruchin.gymster.data.trainings.repository.DefaultTrainingsRepository
import com.maruchin.gymster.data.trainings.repository.TrainingsRepository
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataTrainingsModule = module {

    factoryOf(::DefaultTrainingsRepository) bind TrainingsRepository::class
}
