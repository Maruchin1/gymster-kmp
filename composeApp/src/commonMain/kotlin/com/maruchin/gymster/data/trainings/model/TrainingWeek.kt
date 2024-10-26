package com.maruchin.gymster.data.trainings.model

import com.maruchin.gymster.data.plans.model.Plan
import kotlin.uuid.Uuid
import kotlinx.datetime.LocalDate

internal data class TrainingWeek(
    val id: String = Uuid.random().toString(),
    val startDate: LocalDate,
    val trainings: List<Training>
) {

    companion object {

        internal fun from(plan: Plan, startDate: LocalDate) = TrainingWeek(
            trainings = plan.trainings.map { Training.from(it) },
            startDate = startDate
        )
    }
}
