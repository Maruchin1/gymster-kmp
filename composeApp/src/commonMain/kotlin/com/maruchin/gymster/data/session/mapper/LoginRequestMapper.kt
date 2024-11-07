package com.maruchin.gymster.data.session.mapper

import com.maruchin.gymster.data.session.json.UserLoginRequestJson
import com.maruchin.gymster.data.session.model.LoginRequest

internal fun LoginRequest.toJson() = UserLoginRequestJson(
    username = username,
    password = password
)
