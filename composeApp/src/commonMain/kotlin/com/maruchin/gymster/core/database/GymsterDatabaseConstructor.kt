package com.maruchin.gymster.core.database

import androidx.room.RoomDatabaseConstructor

@Suppress("NO_ACTUAL_FOR_EXPECT")
internal expect object GymsterDatabaseConstructor : RoomDatabaseConstructor<GymsterDatabase> {
    override fun initialize(): GymsterDatabase
}
