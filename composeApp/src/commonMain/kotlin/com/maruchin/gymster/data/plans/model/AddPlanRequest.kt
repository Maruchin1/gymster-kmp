package com.maruchin.gymster.data.plans.model

internal data class AddPlanRequest(val name: String)

internal val samplePushPullAddPlanRequest = AddPlanRequest(name = "Push Pull")
