package com.maruchin.gymster.core.preferences.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import okio.Path.Companion.toPath

fun dataStore(fileName: String, context: Context): DataStore<Preferences> {
    val path = context.filesDir.resolve("$fileName.preferences_pb").absolutePath
    return PreferenceDataStoreFactory.createWithPath { path.toPath() }
}
