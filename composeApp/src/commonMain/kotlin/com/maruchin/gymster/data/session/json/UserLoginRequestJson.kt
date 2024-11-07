package com.maruchin.gymster.data.session.json

import kotlinx.serialization.Serializable

@Serializable
internal data class UserLoginRequestJson(val username: String, val password: String)
