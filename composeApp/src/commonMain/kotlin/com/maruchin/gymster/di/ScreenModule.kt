package com.maruchin.gymster.di

import com.maruchin.gymster.screen.exercisebrowser.ExerciseBrowserViewModel
import com.maruchin.gymster.screen.home.HomeViewModel
import com.maruchin.gymster.screen.login.LoginViewModel
import com.maruchin.gymster.screen.profile.ProfileViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

internal val screenModule = module {

    viewModelOf(::HomeViewModel)

    viewModelOf(::ExerciseBrowserViewModel)

    viewModelOf(::LoginViewModel)

    viewModelOf(::ProfileViewModel)
}
