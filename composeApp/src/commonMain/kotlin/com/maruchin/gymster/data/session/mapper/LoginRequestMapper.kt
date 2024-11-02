package com.maruchin.gymster.data.session.mapper

import com.maruchin.gymster.data.session.json.TokenObtainPairRequestJson
import com.maruchin.gymster.data.session.model.LoginRequest

internal fun LoginRequest.toJson() = TokenObtainPairRequestJson(
    username = username,
    password = password
)
