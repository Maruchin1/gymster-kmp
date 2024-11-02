package com.maruchin.gymster.data.session.mapper

import androidx.datastore.preferences.core.Preferences
import com.maruchin.gymster.core.preferences.SessionPreferences
import com.maruchin.gymster.data.session.model.Session

internal fun Preferences.toSession() = Session(
    accessToken = this[SessionPreferences.accessToken].orEmpty(),
    refreshToken = this[SessionPreferences.refreshToken].orEmpty()
)
