package com.maruchin.gymster.data.plans.mapper

import com.maruchin.gymster.core.database.relation.PlanWithTrainings
import com.maruchin.gymster.data.plans.model.Plan

internal fun PlanWithTrainings.toDomainModel(activePlanId: String?) = Plan(
    id = plan.id,
    name = plan.name,
    isActive = plan.id == activePlanId,
    trainings = trainings.map { it.toDomainModel() }
)
