package com.maruchin.gymster.data.trainings.api

import com.maruchin.gymster.core.preferences.SessionStore
import com.maruchin.gymster.core.utils.tokenAuth
import com.maruchin.gymster.data.common.model.PaginatedListJson
import com.maruchin.gymster.data.trainings.json.SettingJson
import com.maruchin.gymster.data.trainings.json.SettingRequestJson
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.accept
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

internal class SettingApi(
    private val httpClient: HttpClient,
    private val sessionStore: SessionStore
) {

    suspend fun getSettings(setIds: List<Int>): List<SettingJson> = coroutineScope {
        setIds.map { async { getSettings(it) } }
            .awaitAll()
            .flatten()
    }

    suspend fun getSettings(set: Int): List<SettingJson> = httpClient.get("/api/v2/setting/") {
        tokenAuth(sessionStore.getToken())
        parameter("set", set)
        parameter("limit", 100)
    }.body<PaginatedListJson<SettingJson>>().results

    suspend fun addSetting(request: SettingRequestJson): SettingJson =
        httpClient.post("/api/v2/setting/") {
            tokenAuth(sessionStore.getToken())
            accept(ContentType.Application.Json)
            setBody(request)
        }.body()
}
