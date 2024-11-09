package com.maruchin.gymster.data.plans

import com.maruchin.gymster.core.preferences.SessionStore
import com.maruchin.gymster.data.plans.json.PaginatedWorkoutListJson
import com.maruchin.gymster.data.plans.json.WorkoutJson
import com.maruchin.gymster.data.plans.mapper.toDomain
import com.maruchin.gymster.data.plans.mapper.toJson
import com.maruchin.gymster.data.plans.model.AddPlanRequest
import com.maruchin.gymster.data.plans.model.Plan
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.HttpHeaders

internal class PlansRepository(
    private val httpClient: HttpClient,
    private val sessionStore: SessionStore
) {

    suspend fun getAllPlans(): List<Plan> {
        val token = sessionStore.getToken()
        val responseJson = httpClient.get("/api/v2/workout/") {
            header(HttpHeaders.Authorization, "Token $token")
            parameter("ordering", "creation_date")
        }.body<PaginatedWorkoutListJson>()
        return responseJson.results.map { it.toDomain() }
    }

    suspend fun getPlan(planId: Int): Plan {
        val token = sessionStore.getToken()
        val responseJson = httpClient.get("/api/v2/workout/$planId/") {
            header(HttpHeaders.Authorization, "Token $token")
        }.body<WorkoutJson>()
        return responseJson.toDomain()
    }

    suspend fun addPlan(request: AddPlanRequest) {
        val requestJson = request.toJson()
        httpClient.post("/api/v2/workout/") {
            header(HttpHeaders.ContentType, "application/json")
            header(HttpHeaders.Authorization, "Token ${sessionStore.getToken()}")
            setBody(requestJson)
        }
    }

    suspend fun deletePlan(planId: Int) {
        httpClient.delete("/api/v2/workout/$planId/") {
            header(HttpHeaders.Authorization, "Token ${sessionStore.getToken()}")
        }
    }
}
