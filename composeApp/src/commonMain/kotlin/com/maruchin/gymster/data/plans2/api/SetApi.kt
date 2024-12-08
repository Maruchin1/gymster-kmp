package com.maruchin.gymster.data.plans2.api

import com.maruchin.gymster.core.preferences.SessionStore
import com.maruchin.gymster.core.utils.tokenAuth
import com.maruchin.gymster.data.common.model.PaginatedListJson
import com.maruchin.gymster.data.plans2.json.SetJson
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

internal class SetApi(
    private val httpClient: HttpClient,
    private val sessionStore: SessionStore
) {

    suspend fun get(dayId: Int? = null): PaginatedListJson<SetJson> {
        return httpClient.get("/api/v2/set") {
            tokenAuth(sessionStore.getToken())
            parameter("limit", value = 1_000)
            parameter("exerciseday", dayId)
        }.body()
    }

    suspend fun get(id: Int): SetJson? {
        return httpClient.get("/api/v2/set/$id") {
            tokenAuth(sessionStore.getToken())
        }.body()
    }
}
