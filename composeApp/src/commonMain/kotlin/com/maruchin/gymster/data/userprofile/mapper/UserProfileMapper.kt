package com.maruchin.gymster.data.userprofile.mapper

import com.maruchin.gymster.data.userprofile.json.UserProfileJson
import com.maruchin.gymster.data.userprofile.model.UserProfile

internal fun UserProfileJson.toDomain() = UserProfile(username = username, email = email)
