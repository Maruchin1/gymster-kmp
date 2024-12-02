package com.maruchin.gymster.data.trainings.json

import kotlinx.serialization.Serializable

@Serializable
internal data class DayRequestJson(val training: Int, val description: String, val day: List<Int>)

internal val samplePushDayRequestJson = """
    {
      "training": 351492,
      "description": "Push",
      "day": []
    }
""".trimIndent()

internal val samplePullDayRequestJson = """
    {
      "training": 351492,
      "description": "Pull",
      "day": []
    }
""".trimIndent()
