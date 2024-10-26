package com.maruchin.gymster.core.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import java.io.File
import okio.Path.Companion.toPath

actual class PreferencesFactory(private val context: Context) {

    actual fun createDataStore(storeName: String): DataStore<Preferences> {
        val path = context.filesDir.resolve("$storeName.preferences_pb").absolutePath
        return PreferenceDataStoreFactory.createWithPath { path.toPath() }
    }

    actual fun createInMemoryDataStore(storeName: String): DataStore<Preferences> {
        val path = File.createTempFile(storeName, ".preferences_pb").absolutePath
        return PreferenceDataStoreFactory.createWithPath { path.toPath() }
    }
}
