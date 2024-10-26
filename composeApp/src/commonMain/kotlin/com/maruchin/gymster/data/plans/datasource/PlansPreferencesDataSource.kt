package com.maruchin.gymster.data.plans.datasource

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class PlansPreferencesDataSource(private val dataStore: DataStore<Preferences>) {

    fun observeActivePlanId(): Flow<String?> = dataStore.data.map { preferences ->
        preferences[activePlanId]
    }

    suspend fun setActivePlanId(planId: String) {
        dataStore.edit { preferences ->
            preferences[activePlanId] = planId
        }
    }

    suspend fun removeActivePlanId() {
        dataStore.edit { preferences ->
            preferences.remove(activePlanId)
        }
    }

    companion object {

        private val activePlanId = stringPreferencesKey("active_plan_id")
    }
}
