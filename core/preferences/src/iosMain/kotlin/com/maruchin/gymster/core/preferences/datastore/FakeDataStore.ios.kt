package com.maruchin.gymster.core.preferences.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import kotlin.uuid.Uuid
import okio.Path.Companion.toPath
import platform.Foundation.NSTemporaryDirectory

fun fakeDataStore(storeName: String): DataStore<Preferences> {
    val tempDirectory = NSTemporaryDirectory()
    val random = Uuid.random().toString()
    val tempFilePath = "$tempDirectory/$storeName-$random.preferences_pb"
    return PreferenceDataStoreFactory.createWithPath { tempFilePath.toPath() }
}
