package com.maruchin.gymster.data.session.testdata

import com.maruchin.gymster.data.session.json.LoginJson

internal val testLoginJson = LoginJson(token = "56bb8fc80d7a55e9ff201ba42f3e1f9460a8b651")

internal val testLoginJsonRaw = """
    {
      "token": "56bb8fc80d7a55e9ff201ba42f3e1f9460a8b651"
    }
""".trimIndent()

internal val testLoginJsonRawInvalidCredentials = """
    {
      "non_field_errors": [
        "Username or password unknown"
      ]
    }
""".trimIndent()
