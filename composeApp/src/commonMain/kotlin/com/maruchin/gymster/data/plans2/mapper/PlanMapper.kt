package com.maruchin.gymster.data.plans2.mapper

import com.maruchin.gymster.data.plans2.json.WorkoutJson
import com.maruchin.gymster.data.plans2.model.Plan
import com.maruchin.gymster.data.plans2.model.WorkoutTemplate

internal fun WorkoutJson.toDomain(workouts: List<WorkoutTemplate>) = Plan(
    id = id,
    name = name,
    workouts = workouts
)
