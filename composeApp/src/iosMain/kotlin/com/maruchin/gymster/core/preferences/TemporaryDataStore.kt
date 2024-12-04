package com.maruchin.gymster.core.preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import okio.Path.Companion.toPath
import platform.Foundation.NSTemporaryDirectory
import kotlin.uuid.Uuid

internal fun temporaryDataStore(name: String): DataStore<Preferences> {
    val tempDirectory = NSTemporaryDirectory()
    val random = Uuid.random().toString()
    val tempFilePath = "$tempDirectory/$name-$random.preferences_pb"
    return PreferenceDataStoreFactory.createWithPath { tempFilePath.toPath() }
}
