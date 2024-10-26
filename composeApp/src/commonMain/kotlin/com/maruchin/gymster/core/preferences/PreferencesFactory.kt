package com.maruchin.gymster.core.preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

internal expect class PreferencesFactory {

    fun createDataStore(storeName: String): DataStore<Preferences>

    fun createInMemoryDataStore(storeName: String): DataStore<Preferences>
}
