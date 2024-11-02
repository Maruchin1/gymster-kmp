package com.maruchin.gymster.data.session.json

internal val testTokenObtainPairJson = """
    {
      "refresh": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlbl90eXBlIjoicmVmcmVzaCIsImV4cCI6MTczMDY2NzQ1MiwiaWF0IjoxNzMwNTgxMDUyLCJqdGkiOiI4MDEyOTg2YTA1MzY0NDMyOTE4YjQ4MTM4NGJhYWUxYyIsInVzZXJfaWQiOjIwODM2MH0.Wy_a87RsIrf06rt222kO5eOmz3XzebNSO4wI-WObbHE",
      "access": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlbl90eXBlIjoiYWNjZXNzIiwiZXhwIjoxNzMwNTgxNjUyLCJpYXQiOjE3MzA1ODEwNTIsImp0aSI6Ijg4ZjBjM2M0ZGVjMDQzM2NhMzE1MWIwYjliM2UxYTYyIiwidXNlcl9pZCI6MjA4MzYwfQ.h3BWf2nAdnu0sEJGYTXeTQhZ5Jxo7rWloIFK4c7prWI"
    }
""".trimIndent()

internal val testTokenObtainPairJsonInvalidCredentials = """
    {
      "detail": "No active account found with the given credentials"
    }
""".trimIndent()
