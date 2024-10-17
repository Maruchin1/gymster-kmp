package com.maruchin.gymster.core.preferences.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import java.io.File
import okio.Path.Companion.toPath

fun fakeDataStore(storeName: String): DataStore<Preferences> {
    val path = File.createTempFile(storeName, ".preferences_pb").absolutePath
    return PreferenceDataStoreFactory.createWithPath { path.toPath() }
}
