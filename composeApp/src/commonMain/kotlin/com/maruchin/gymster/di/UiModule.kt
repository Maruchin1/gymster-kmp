package com.maruchin.gymster.di

import com.maruchin.gymster.ui.home.HomeViewModel
import com.maruchin.gymster.ui.plandetails.PlanDetailsViewModel
import com.maruchin.gymster.ui.planlist.PlanListViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

internal val uiModule = module {

    viewModelOf(::HomeViewModel)

    viewModelOf(::PlanListViewModel)

    viewModel { PlanDetailsViewModel(it[0], get()) }
}
