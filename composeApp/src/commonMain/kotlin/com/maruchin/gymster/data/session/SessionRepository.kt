package com.maruchin.gymster.data.session

import com.maruchin.gymster.core.preferences.SessionStore
import com.maruchin.gymster.data.session.json.LoginJson
import com.maruchin.gymster.data.session.mapper.toJson
import com.maruchin.gymster.data.session.model.LoginRequest
import com.maruchin.gymster.data.session.model.LoginResult
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class SessionRepository(
    private val httpClient: HttpClient,
    private val sessionStore: SessionStore
) {

    val isLoggedInFlow: Flow<Boolean> = sessionStore.tokenFlow.map { it != null }

    suspend fun login(request: LoginRequest): LoginResult = try {
        val requestJson = request.toJson()
        val responseJson = httpClient.post("/api/v2/login/") {
            setBody(requestJson)
        }.body<LoginJson>()
        sessionStore.saveToken(responseJson.token)
        LoginResult.Success
    } catch (e: ClientRequestException) {
        if (e.response.status == HttpStatusCode.BadRequest) {
            LoginResult.InvalidCredentials
        } else {
            throw e
        }
    }

    suspend fun logout() {
        sessionStore.removeToken()
    }
}
