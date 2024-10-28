package com.maruchin.gymster.di

import com.maruchin.gymster.core.database.FakeGymsterDatabase
import com.maruchin.gymster.core.database.GymsterDatabase
import com.maruchin.gymster.core.database.dao.ExerciseDao
import com.maruchin.gymster.core.database.dao.PlanDao
import com.maruchin.gymster.core.database.dao.PlanExerciseDao
import com.maruchin.gymster.core.database.dao.PlanTrainingDao
import com.maruchin.gymster.core.database.dao.SetResultDao
import com.maruchin.gymster.core.database.dao.TrainingDao
import com.maruchin.gymster.core.database.dao.TrainingWeekDao
import com.maruchin.gymster.core.database.fakedao.FakeExerciseDao
import com.maruchin.gymster.core.database.fakedao.FakePlanDao
import com.maruchin.gymster.core.database.fakedao.FakePlanExerciseDao
import com.maruchin.gymster.core.database.fakedao.FakePlanTrainingDao
import com.maruchin.gymster.core.database.fakedao.FakeSetResultDao
import com.maruchin.gymster.core.database.fakedao.FakeTrainingDao
import com.maruchin.gymster.core.database.fakedao.FakeTrainingWeekDao
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

internal val databaseModule = module {

    includes(databasePlatformModule)

    single { GymsterDatabase.create(get()) }

    factory { get<GymsterDatabase>().planDao }

    factory { get<GymsterDatabase>().planTrainingDao }

    factory { get<GymsterDatabase>().planExerciseDao }

    factory { get<GymsterDatabase>().trainingWeekDao }

    factory { get<GymsterDatabase>().trainingDao }

    factory { get<GymsterDatabase>().exerciseDao }

    factory { get<GymsterDatabase>().setResultDao }
}

internal val testDatabaseModule = module {

    single { FakeGymsterDatabase() }

    factory { FakePlanDao(get()) } bind PlanDao::class

    factory { FakePlanTrainingDao(get()) } bind PlanTrainingDao::class

    factory { FakePlanExerciseDao(get()) } bind PlanExerciseDao::class

    factory { FakeTrainingWeekDao(get()) } bind TrainingWeekDao::class

    factory { FakeTrainingDao(get()) } bind TrainingDao::class

    factory { FakeExerciseDao(get()) } bind ExerciseDao::class

    factory { FakeSetResultDao(get()) } bind SetResultDao::class
}

internal expect val databasePlatformModule: Module
