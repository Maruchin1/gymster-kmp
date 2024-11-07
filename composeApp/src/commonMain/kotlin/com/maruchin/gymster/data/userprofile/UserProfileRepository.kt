package com.maruchin.gymster.data.userprofile

import com.maruchin.gymster.core.preferences.SessionStore
import com.maruchin.gymster.data.userprofile.json.UserProfileJson
import com.maruchin.gymster.data.userprofile.mapper.toDomain
import com.maruchin.gymster.data.userprofile.model.UserProfile
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.http.HttpHeaders

internal class UserProfileRepository(
    private val httpClient: HttpClient,
    private val preferences: SessionStore
) {

    suspend fun getUserProfile(): UserProfile {
        val token = preferences.getToken()
        val response = httpClient.get("/api/v2/userprofile/") {
            header(HttpHeaders.Authorization, "Token $token")
        }.body<UserProfileJson>()
        return response.toDomain()
    }
}
