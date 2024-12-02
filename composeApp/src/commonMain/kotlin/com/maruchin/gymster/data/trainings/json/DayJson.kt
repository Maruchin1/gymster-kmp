package com.maruchin.gymster.data.trainings.json

import kotlinx.serialization.Serializable

@Serializable
internal data class DayJson(val id: Int, val description: String)

internal val sampleEmptyDayListJson = """
    {
      "count": 0,
      "next": null,
      "previous": null,
      "results": []
    }
""".trimIndent()

internal val samplePushDayJson = """
    {
        "id": 199701,
        "training": 351492,
        "description": "Push",
        "day": []
    }
""".trimIndent()

internal val samplePullDayJson = """
    {
      "id": 199703,
      "training": 351492,
      "description": "Pull",
      "day": []
    }
""".trimIndent()

internal val samplePushDayListJson = """
    {
      "count": 2,
      "next": null,
      "previous": null,
      "results": [
        {
          "id": 199701,
          "training": 351492,
          "description": "Push",
          "day": []
        }
      ]
    }
""".trimIndent()

internal val samplePushAndPullDayListJson = """
    {
      "count": 2,
      "next": null,
      "previous": null,
      "results": [
        {
          "id": 199701,
          "training": 351492,
          "description": "Push",
          "day": []
        },
        {
          "id": 199703,
          "training": 351492,
          "description": "Pull",
          "day": []
        }
      ]
    }
""".trimIndent()
