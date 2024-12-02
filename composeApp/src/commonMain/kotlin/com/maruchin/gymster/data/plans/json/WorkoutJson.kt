package com.maruchin.gymster.data.plans.json

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class WorkoutJson(
    val id: Int,
    val name: String,
    @SerialName("creation_date") val creationDate: String
)

internal val samplePushPullWorkoutJson = """
    {
      "id": 351492,
      "name": "Push Pull",
      "creation_date": "2024-11-23",
      "description": ""
    }
""".trimIndent()

internal val sampleUpdatedPushPullWorkoutJson = """
    {
      "id": 351492,
      "name": "Push Pull Legs",
      "creation_date": "2024-11-23",
      "description": ""
    }
""".trimIndent()

internal val sampleEmptyWorkoutListJson = """
    {
      "count": 0,
      "next": null,
      "previous": null,
      "results": []
    }
""".trimIndent()

internal val sampleOnePlanWorkoutListJson = """
    {
      "count": 1,
      "next": null,
      "previous": null,
      "results": [
        {
          "id": 351492,
          "name": "Push Pull",
          "creation_date": "2024-11-23",
          "description": ""
        }
      ]
    }
""".trimIndent()
