package com.maruchin.gymster.data.trainings.model

import com.maruchin.gymster.data.plans.model.PlanTraining
import kotlin.uuid.Uuid
import kotlinx.datetime.LocalDate

data class Training(
    val id: String = Uuid.random().toString(),
    val name: String,
    val exercises: List<Exercise>,
    val date: LocalDate? = null
) {

    fun getSetResult(setResultId: String): SetResult =
        exercises.flatMap { it.setsResults }.first { it.id == setResultId }

    companion object {

        internal fun from(planTraining: PlanTraining) = Training(
            name = planTraining.name,
            exercises = planTraining.exercises.map { Exercise.from(it) }
        )
    }
}
