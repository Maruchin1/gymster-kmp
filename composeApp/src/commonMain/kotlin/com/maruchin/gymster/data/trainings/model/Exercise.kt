package com.maruchin.gymster.data.trainings.model

import com.maruchin.gymster.data.plans.model.PlanExercise
import kotlin.uuid.Uuid

internal data class Exercise(
    val id: String = Uuid.random().toString(),
    val name: String,
    val sets: Int,
    val reps: IntRange,
    val setsResults: List<SetResult>
) {

    init {
//        require(sets == setsResults.size)
    }

    val isComplete: Boolean
        get() = setsResults.all { it.isComplete }

    val numOfCompletedSets: Int
        get() = setsResults.count { it.isComplete }

    companion object {

        internal fun from(planExercise: PlanExercise) = Exercise(
            name = planExercise.name,
            sets = planExercise.sets,
            reps = planExercise.reps,
            setsResults = (1..planExercise.sets).map { SetResult() }
        )
    }
}
