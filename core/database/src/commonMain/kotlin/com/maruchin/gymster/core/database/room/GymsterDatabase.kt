package com.maruchin.gymster.core.database.room

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.maruchin.gymster.core.database.converter.LocalDateConverter
import com.maruchin.gymster.core.database.dao.ExerciseDao
import com.maruchin.gymster.core.database.dao.PlanDao
import com.maruchin.gymster.core.database.dao.PlanExerciseDao
import com.maruchin.gymster.core.database.dao.PlanTrainingDao
import com.maruchin.gymster.core.database.dao.SetResultDao
import com.maruchin.gymster.core.database.dao.TrainingDao
import com.maruchin.gymster.core.database.dao.TrainingWeekDao
import com.maruchin.gymster.core.database.entity.ExerciseEntity
import com.maruchin.gymster.core.database.entity.PlanEntity
import com.maruchin.gymster.core.database.entity.PlanExerciseEntity
import com.maruchin.gymster.core.database.entity.PlanTrainingEntity
import com.maruchin.gymster.core.database.entity.SetResultEntity
import com.maruchin.gymster.core.database.entity.TrainingEntity
import com.maruchin.gymster.core.database.entity.TrainingWeekEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

@Database(
    entities = [
        PlanEntity::class,
        PlanTrainingEntity::class,
        PlanExerciseEntity::class,
        TrainingWeekEntity::class,
        TrainingEntity::class,
        ExerciseEntity::class,
        SetResultEntity::class
    ],
    version = 1
)
@TypeConverters(LocalDateConverter::class)
@ConstructedBy(GymsterDatabaseConstructor::class)
internal abstract class GymsterDatabase : RoomDatabase() {
    abstract val planDao: PlanDao
    abstract val planTrainingDao: PlanTrainingDao
    abstract val planExerciseDao: PlanExerciseDao
    abstract val trainingWeekDao: TrainingWeekDao
    abstract val trainingDao: TrainingDao
    abstract val exerciseDao: ExerciseDao
    abstract val setResultDao: SetResultDao

    companion object {

        fun create(builder: Builder<GymsterDatabase>): GymsterDatabase = builder
            .fallbackToDestructiveMigration(dropAllTables = false)
            .setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
    }
}
