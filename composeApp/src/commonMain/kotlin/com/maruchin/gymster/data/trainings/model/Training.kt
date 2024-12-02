package com.maruchin.gymster.data.trainings.model

internal data class Training(val id: Int, val name: String, val exercises: List<Exercise>)

internal val sampleEmptyPushTraining = Training(
    id = 199701,
    name = "Push",
    exercises = emptyList()
)

internal val sampleEmptyPullTraining = Training(
    id = 199703,
    name = "Pull",
    exercises = emptyList()
)
