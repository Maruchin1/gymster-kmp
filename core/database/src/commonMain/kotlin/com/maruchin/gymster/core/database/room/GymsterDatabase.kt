package com.maruchin.gymster.core.database.room

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.maruchin.gymster.core.database.dao.PlanDao
import com.maruchin.gymster.core.database.dao.PlanExerciseDao
import com.maruchin.gymster.core.database.dao.PlanTrainingDao
import com.maruchin.gymster.core.database.entity.PlanEntity
import com.maruchin.gymster.core.database.entity.PlanExerciseEntity
import com.maruchin.gymster.core.database.entity.PlanTrainingEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

@Database(
    entities = [
        PlanEntity::class,
        PlanTrainingEntity::class,
        PlanExerciseEntity::class
    ],
    version = 1
)
@ConstructedBy(GymsterDatabaseConstructor::class)
internal abstract class GymsterDatabase : RoomDatabase() {
    abstract val planDao: PlanDao
    abstract val planTrainingDao: PlanTrainingDao
    abstract val planExerciseDao: PlanExerciseDao

    companion object {

        fun create(builder: Builder<GymsterDatabase>): GymsterDatabase = builder
            .fallbackToDestructiveMigrationOnDowngrade(dropAllTables = true)
            .setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
    }
}
