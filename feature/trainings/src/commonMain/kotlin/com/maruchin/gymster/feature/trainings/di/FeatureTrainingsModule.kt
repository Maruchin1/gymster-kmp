package com.maruchin.gymster.feature.trainings.di

import com.maruchin.gymster.feature.trainings.details.TrainingDetailsViewModel
import com.maruchin.gymster.feature.trainings.history.TrainingHistoryViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val featureTrainingsModule = module {

    viewModelOf(::TrainingHistoryViewModel)

    viewModel { TrainingDetailsViewModel(it[0], get()) }
}
