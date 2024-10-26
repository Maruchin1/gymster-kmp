package com.maruchin.gymster.core.database.fakedao

import com.maruchin.gymster.core.database.FakeGymsterDatabase
import com.maruchin.gymster.core.database.dao.SetResultDao
import com.maruchin.gymster.core.database.entity.SetResultEntity
import kotlinx.coroutines.flow.update

internal class FakeSetResultDao internal constructor(private val database: FakeGymsterDatabase) :
    SetResultDao {

    override suspend fun getSetResult(setResultId: String): SetResultEntity? =
        database.setResults.value[setResultId]

    override suspend fun insert(setResults: List<SetResultEntity>) {
        database.setResults.update { map ->
            map + setResults.associateBy { it.id }
        }
    }

    override suspend fun update(setResult: SetResultEntity) {
        database.setResults.update { map ->
            map + (setResult.id to setResult)
        }
    }
}
