package com.maruchin.gymster.core.preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

internal class SessionStore(private val store: DataStore<Preferences>) {

    val tokenFlow: Flow<String?> = store.data.map { it[token] }

    suspend fun getToken(): String? = store.data.first()[token]

    suspend fun saveToken(value: String) {
        store.edit { it[token] = value }
    }

    suspend fun removeToken() {
        store.edit { it.remove(token) }
    }

    companion object {

        const val NAME = "session_preferences"

        private val token = stringPreferencesKey("token")
    }
}
