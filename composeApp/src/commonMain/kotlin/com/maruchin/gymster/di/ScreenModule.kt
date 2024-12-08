package com.maruchin.gymster.di

import com.maruchin.gymster.screen.exercisebrowser.ExerciseBrowserViewModel
import com.maruchin.gymster.screen.home.HomeViewModel
import com.maruchin.gymster.screen.login.LoginViewModel
import com.maruchin.gymster.screen.plandetails.PlanDetailsViewModel
import com.maruchin.gymster.screen.planlist.PlanListViewModel
import com.maruchin.gymster.screen.profile.ProfileViewModel
import com.maruchin.gymster.screen.startworkout.StartWorkoutViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

internal val screenModule = module {

    viewModelOf(::HomeViewModel)

    viewModelOf(::ExerciseBrowserViewModel)

    viewModelOf(::LoginViewModel)

    viewModelOf(::ProfileViewModel)

    viewModelOf(::PlanListViewModel)

    viewModel { PlanDetailsViewModel(it[0], get(), get()) }

    viewModelOf(::StartWorkoutViewModel)
}
