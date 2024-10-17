package com.maruchin.gymster.feature.home.di

import com.maruchin.gymster.feature.home.HomeViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val featureHomeModule = module {

    viewModelOf(::HomeViewModel)
}
