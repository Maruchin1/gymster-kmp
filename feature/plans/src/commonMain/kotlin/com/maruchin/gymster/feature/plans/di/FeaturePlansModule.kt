package com.maruchin.gymster.feature.plans.di

import com.maruchin.gymster.feature.plans.plandetails.PlanDetailsViewModel
import com.maruchin.gymster.feature.plans.planlist.PlanListViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val featurePlansModule = module {

    viewModelOf(::PlanListViewModel)

    viewModel { PlanDetailsViewModel(it[0], get()) }
}
