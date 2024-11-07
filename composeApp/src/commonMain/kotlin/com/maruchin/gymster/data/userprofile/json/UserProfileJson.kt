package com.maruchin.gymster.data.userprofile.json

import kotlinx.serialization.Serializable

@Serializable
internal data class UserProfileJson(val username: String, val email: String)
