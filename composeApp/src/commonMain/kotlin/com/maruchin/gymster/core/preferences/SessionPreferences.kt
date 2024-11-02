package com.maruchin.gymster.core.preferences

import androidx.datastore.preferences.core.stringPreferencesKey

object SessionPreferences {

    const val NAME = "user_preferences"

    val accessToken = stringPreferencesKey("access_token")

    val refreshToken = stringPreferencesKey("refresh_token")
}
