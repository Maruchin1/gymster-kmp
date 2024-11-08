package com.maruchin.gymster.data.plans.mapper

import com.maruchin.gymster.data.plans.json.WorkoutJson
import com.maruchin.gymster.data.plans.model.Plan
import kotlinx.datetime.LocalDate

internal fun WorkoutJson.toDomain() = Plan(
    id = id,
    name = name,
    creationDate = LocalDate.parse(creationDate)
)
