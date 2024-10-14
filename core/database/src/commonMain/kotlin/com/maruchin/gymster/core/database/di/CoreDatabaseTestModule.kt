package com.maruchin.gymster.core.database.di

import com.maruchin.gymster.core.database.dao.FakePlanDao
import com.maruchin.gymster.core.database.dao.FakePlanExerciseDao
import com.maruchin.gymster.core.database.dao.FakePlanTrainingDao
import com.maruchin.gymster.core.database.dao.PlanDao
import com.maruchin.gymster.core.database.dao.PlanExerciseDao
import com.maruchin.gymster.core.database.dao.PlanTrainingDao
import com.maruchin.gymster.core.database.room.FakeGymsterDatabase
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDatabaseTestModule = module {

    single { FakeGymsterDatabase() }

    factory { FakePlanDao(get()) } bind PlanDao::class

    factory { FakePlanTrainingDao(get()) } bind PlanTrainingDao::class

    factory { FakePlanExerciseDao(get()) } bind PlanExerciseDao::class
}
