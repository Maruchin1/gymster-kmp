package com.maruchin.gymster.data.plans.mapper

import com.maruchin.gymster.core.database.relation.PlanWithTrainings
import com.maruchin.gymster.data.plans.model.Plan

internal fun PlanWithTrainings.toDomainModel() = Plan(
    id = plan.id,
    name = plan.name,
    trainings = trainings.map { it.toDomainModel() }
)
