package com.maruchin.gymster.core.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import okio.Path.Companion.toPath

internal fun dataStore(name: String, context: Context): DataStore<Preferences> {
    val path = context.filesDir.resolve("$name.preferences_pb").absolutePath
    return PreferenceDataStoreFactory.createWithPath { path.toPath() }
}
