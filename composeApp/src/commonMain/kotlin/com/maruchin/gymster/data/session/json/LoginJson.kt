package com.maruchin.gymster.data.session.json

import kotlinx.serialization.Serializable

@Serializable
internal data class LoginJson(val token: String)
