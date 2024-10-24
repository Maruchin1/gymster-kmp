package com.maruchin.gymster.di

import com.maruchin.gymster.ui.home.HomeViewModel
import com.maruchin.gymster.ui.plandetails.PlanDetailsViewModel
import com.maruchin.gymster.ui.planlist.PlanListViewModel
import com.maruchin.gymster.ui.trainingdetails.TrainingDetailsViewModel
import com.maruchin.gymster.ui.traininghistory.TrainingHistoryViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

internal val uiModule = module {

    viewModelOf(::HomeViewModel)

    viewModelOf(::PlanListViewModel)

    viewModel { PlanDetailsViewModel(it[0], get()) }

    viewModelOf(::TrainingHistoryViewModel)

    viewModel { TrainingDetailsViewModel(it[0], get()) }
}
