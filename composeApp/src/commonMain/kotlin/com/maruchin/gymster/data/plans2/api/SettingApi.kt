package com.maruchin.gymster.data.plans2.api

import com.maruchin.gymster.core.preferences.SessionStore
import com.maruchin.gymster.core.utils.tokenAuth
import com.maruchin.gymster.data.common.model.PaginatedListJson
import com.maruchin.gymster.data.plans2.json.SettingJson
import com.maruchin.gymster.data.plans2.json.SettingRequestJson
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody

internal class SettingApi(
    private val httpClient: HttpClient,
    private val sessionStore: SessionStore
) {

    suspend fun get(setId: Int? = null): PaginatedListJson<SettingJson> {
        return httpClient.get("/api/v2/setting/") {
            tokenAuth(sessionStore.getToken())
            parameter("limit", value = 1_000)
            parameter("set", setId)
        }.body()
    }

    suspend fun get(id: Int): SettingJson? {
        return httpClient.get("/api/v2/setting/$id/") {
            tokenAuth(sessionStore.getToken())
        }.body()
    }

    suspend fun post(body: SettingRequestJson): SettingJson {
        return httpClient.post("/api/v2/setting/") {
            tokenAuth(sessionStore.getToken())
            setBody(body)
        }.body()
    }

    suspend fun delete(id: Int) {
        httpClient.delete("/api/v2/setting/$id/") {
            tokenAuth(sessionStore.getToken())
        }
    }
}
