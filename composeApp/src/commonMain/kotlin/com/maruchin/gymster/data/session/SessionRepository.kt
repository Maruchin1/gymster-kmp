package com.maruchin.gymster.data.session

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.maruchin.gymster.core.preferences.SessionPreferences
import com.maruchin.gymster.data.session.json.TokenObtainPairJson
import com.maruchin.gymster.data.session.mapper.toJson
import com.maruchin.gymster.data.session.mapper.toSession
import com.maruchin.gymster.data.session.model.InvalidCredentialsException
import com.maruchin.gymster.data.session.model.LoginRequest
import com.maruchin.gymster.data.session.model.Session
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
    private val store: DataStore<Preferences>
) {

    fun observeSession(): Flow<Session> = store.data.map { it.toSession() }

    suspend fun login(request: LoginRequest) {
        try {
            val requestBody = request.toJson()
            val response = httpClient.post("/api/v2/token") {
                setBody(requestBody)
            }
            val responseBody = response.body<TokenObtainPairJson>()
            store.edit {
                it[SessionPreferences.accessToken] = responseBody.access
                it[SessionPreferences.refreshToken] = responseBody.refresh
            }
        } catch (e: ClientRequestException) {
            if (e.response.status == HttpStatusCode.Unauthorized) {
                throw InvalidCredentialsException()
            }
            throw e
        }
    }

    suspend fun logout() {
        store.edit {
            it.remove(SessionPreferences.accessToken)
            it.remove(SessionPreferences.refreshToken)
        }
    }
}
