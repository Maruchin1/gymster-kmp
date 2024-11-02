package com.maruchin.gymster.di

import com.maruchin.gymster.screen.exercisebrowser.ExerciseBrowserViewModel
import com.maruchin.gymster.screen.home.HomeViewModel
import com.maruchin.gymster.screen.login.LoginViewModel
import com.maruchin.gymster.screen.plandetails.PlanDetailsViewModel
import com.maruchin.gymster.screen.planlist.PlanListViewModel
import com.maruchin.gymster.screen.trainingdetails.TrainingDetailsViewModel
import com.maruchin.gymster.screen.traininghistory.TrainingHistoryViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

internal val screenModule = module {

    viewModelOf(::HomeViewModel)

    viewModelOf(::PlanListViewModel)

    viewModel { PlanDetailsViewModel(it[0], get()) }

    viewModelOf(::TrainingHistoryViewModel)

    viewModel { TrainingDetailsViewModel(it[0], get()) }

    viewModelOf(::ExerciseBrowserViewModel)

    viewModelOf(::LoginViewModel)
}
