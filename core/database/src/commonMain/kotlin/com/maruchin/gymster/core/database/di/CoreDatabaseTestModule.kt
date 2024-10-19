package com.maruchin.gymster.core.database.di

import com.maruchin.gymster.core.database.dao.ExerciseDao
import com.maruchin.gymster.core.database.dao.FakeExerciseDao
import com.maruchin.gymster.core.database.dao.FakePlanDao
import com.maruchin.gymster.core.database.dao.FakePlanExerciseDao
import com.maruchin.gymster.core.database.dao.FakePlanTrainingDao
import com.maruchin.gymster.core.database.dao.FakeSetResultDao
import com.maruchin.gymster.core.database.dao.FakeTrainingDao
import com.maruchin.gymster.core.database.dao.FakeTrainingWeekDao
import com.maruchin.gymster.core.database.dao.PlanDao
import com.maruchin.gymster.core.database.dao.PlanExerciseDao
import com.maruchin.gymster.core.database.dao.PlanTrainingDao
import com.maruchin.gymster.core.database.dao.SetResultDao
import com.maruchin.gymster.core.database.dao.TrainingDao
import com.maruchin.gymster.core.database.dao.TrainingWeekDao
import com.maruchin.gymster.core.database.room.FakeGymsterDatabase
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDatabaseTestModule = module {

    singleOf(::FakeGymsterDatabase)

    factoryOf(::FakePlanDao) bind PlanDao::class

    factoryOf(::FakePlanTrainingDao) bind PlanTrainingDao::class

    factoryOf(::FakePlanExerciseDao) bind PlanExerciseDao::class

    factoryOf(::FakeTrainingWeekDao) bind TrainingWeekDao::class

    factoryOf(::FakeTrainingDao) bind TrainingDao::class

    factoryOf(::FakeExerciseDao) bind ExerciseDao::class

    factoryOf(::FakeSetResultDao) bind SetResultDao::class
}
