package com.maruchin.gymster.data.session.json

import kotlinx.serialization.Serializable

@Serializable
internal data class TokenObtainPairJson(val access: String, val refresh: String)
