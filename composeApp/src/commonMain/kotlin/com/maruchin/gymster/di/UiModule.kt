package com.maruchin.gymster.di

import com.maruchin.gymster.ui.home.HomeViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

internal val uiModule = module {

    viewModelOf(::HomeViewModel)
}
