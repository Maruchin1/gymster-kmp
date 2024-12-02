package com.maruchin.gymster.data.plans.model

import kotlinx.datetime.LocalDate

internal data class Plan(val id: Int, val name: String, val creationDate: LocalDate)

internal val samplePushPullPlan = Plan(
    id = 351492,
    name = "Push Pull",
    creationDate = LocalDate(2024, 11, 23)
)
