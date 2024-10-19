package com.maruchin.gymster.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.maruchin.gymster.core.database.entity.SetResultEntity

@Dao
interface SetResultDao {

    @Query("SELECT * FROM SetResultEntity WHERE id = :setResultId")
    suspend fun getSetResult(setResultId: String): SetResultEntity?

    @Insert
    suspend fun insert(setResults: List<SetResultEntity>)

    @Update
    suspend fun update(setResult: SetResultEntity)
}
