package com.maruchin.gymster.data.session.json

import kotlinx.serialization.Serializable

@Serializable
internal data class TokenObtainPairRequestJson(val username: String, val password: String)
