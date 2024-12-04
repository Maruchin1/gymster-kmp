package com.maruchin.gymster.core.preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import okio.Path.Companion.toPath
import java.io.File

internal fun temporaryDataStore(name: String): DataStore<Preferences> {
    val path = File.createTempFile(name, ".preferences_pb").absolutePath
    return PreferenceDataStoreFactory.createWithPath { path.toPath() }
}
