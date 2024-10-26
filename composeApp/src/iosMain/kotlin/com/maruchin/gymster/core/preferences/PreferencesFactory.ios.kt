package com.maruchin.gymster.core.preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import kotlin.uuid.Uuid
import kotlinx.cinterop.ExperimentalForeignApi
import okio.Path.Companion.toPath
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSTemporaryDirectory
import platform.Foundation.NSURL
import platform.Foundation.NSUserDomainMask

@OptIn(ExperimentalForeignApi::class)
actual class PreferencesFactory {

    actual fun createDataStore(storeName: String): DataStore<Preferences> {
        val documentDirectory: NSURL? = NSFileManager.defaultManager.URLForDirectory(
            directory = NSDocumentDirectory,
            inDomain = NSUserDomainMask,
            appropriateForURL = null,
            create = false,
            error = null
        )
        val path = requireNotNull(documentDirectory).path + "/$storeName.preferences_pb"
        return PreferenceDataStoreFactory.createWithPath { path.toPath() }
    }

    actual fun createInMemoryDataStore(storeName: String): DataStore<Preferences> {
        val tempDirectory = NSTemporaryDirectory()
        val random = Uuid.random().toString()
        val tempFilePath = "$tempDirectory/$storeName-$random.preferences_pb"
        return PreferenceDataStoreFactory.createWithPath { tempFilePath.toPath() }
    }
}
