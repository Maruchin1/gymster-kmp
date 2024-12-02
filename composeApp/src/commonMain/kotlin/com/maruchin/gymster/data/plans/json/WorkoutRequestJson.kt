package com.maruchin.gymster.data.plans.json

import kotlinx.serialization.Serializable

@Serializable
internal data class WorkoutRequestJson(val name: String)

internal val samplePushPullWorkoutRequestJson = """
    {
      "name": "Push Pull"
    }
""".trimIndent()
