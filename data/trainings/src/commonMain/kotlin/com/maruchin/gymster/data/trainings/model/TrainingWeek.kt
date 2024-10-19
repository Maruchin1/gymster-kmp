package com.maruchin.gymster.data.trainings.model

import com.maruchin.gymster.data.plans.model.Plan
import kotlin.uuid.Uuid
import kotlinx.datetime.LocalDate

data class TrainingWeek(
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

val samplePushPullLegsTrainingWeek = TrainingWeek(
    startDate = LocalDate(2024, 10, 21),
    trainings = listOf(
        Training(
            name = "Push",
            exercises = listOf(
                Exercise(
                    name = "Wyciskanie sztangi na ławce poziomej",
                    sets = 3,
                    reps = 4..6,
                    setsResults = listOf(
                        SetResult(),
                        SetResult(),
                        SetResult()
                    )
                ),
                Exercise(
                    name = "Rozpiętki hantlami na ławce skos dodatni",
                    sets = 3,
                    reps = 10..12,
                    setsResults = listOf(
                        SetResult(),
                        SetResult(),
                        SetResult()
                    )
                ),
                Exercise(
                    name = "Wyciskanie hantlami nad głowę siedząc",
                    sets = 3,
                    reps = 8..10,
                    setsResults = listOf(
                        SetResult(),
                        SetResult(),
                        SetResult()
                    )
                ),
                Exercise(
                    name = "Wznosy hantli bokiem stojąc",
                    sets = 3,
                    reps = 10..20,
                    setsResults = listOf(
                        SetResult(),
                        SetResult(),
                        SetResult()
                    )
                ),
                Exercise(
                    name = "Prostowanie ramion na wyciągu",
                    sets = 3,
                    reps = 10..12,
                    setsResults = listOf(
                        SetResult(),
                        SetResult(),
                        SetResult()
                    )
                )
            )
        ),
        Training(
            name = "Pull",
            exercises = listOf(
                Exercise(
                    name = "Wiosłowanie sztangą",
                    sets = 3,
                    reps = 6..8,
                    setsResults = listOf(
                        SetResult(),
                        SetResult(),
                        SetResult()
                    )
                ),
                Exercise(
                    name = "Ściąganie drążka wyciągu górnego chwytem V",
                    sets = 3,
                    reps = 8..10,
                    setsResults = listOf(
                        SetResult(),
                        SetResult(),
                        SetResult()
                    )
                ),
                Exercise(
                    name = "Wisoławanie hantlami w oparciu o ławkę",
                    sets = 2,
                    reps = 10..12,
                    setsResults = listOf(
                        SetResult(),
                        SetResult()
                    )
                ),
                Exercise(
                    name = "Odwrotne rozpiętki hantlami w oparciu o ławkę",
                    sets = 3,
                    reps = 10..20,
                    setsResults = listOf(
                        SetResult(),
                        SetResult(),
                        SetResult()
                    )
                ),
                Exercise(
                    name = "Uginanie hantli na modlitewniku",
                    sets = 3,
                    reps = 10..12,
                    setsResults = listOf(
                        SetResult(),
                        SetResult(),
                        SetResult()
                    )
                )
            )
        ),
        Training(
            name = "Legs",
            exercises = listOf(
                Exercise(
                    name = "Przysiad ze sztangą z tyłu",
                    sets = 3,
                    reps = 4..6,
                    setsResults = listOf(
                        SetResult(),
                        SetResult(),
                        SetResult()
                    )
                ),
                Exercise(
                    name = "Wypychanie nóg na suwnicy",
                    sets = 3,
                    reps = 8..10,
                    setsResults = listOf(
                        SetResult(),
                        SetResult(),
                        SetResult()
                    )
                ),
                Exercise(
                    name = "Uginanie nóg leżąc na maszynie",
                    sets = 3,
                    reps = 10..12,
                    setsResults = listOf(
                        SetResult(),
                        SetResult(),
                        SetResult()
                    )
                ),
                Exercise(
                    name = "Wyprosty tułowia na ławce rzymskiej",
                    sets = 3,
                    reps = 10..12,
                    setsResults = listOf(
                        SetResult(),
                        SetResult(),
                        SetResult()
                    )
                ),
                Exercise(
                    name = "Wspięcia na palce na suwnicy",
                    sets = 3,
                    reps = 10..20,
                    setsResults = listOf(
                        SetResult(),
                        SetResult(),
                        SetResult()
                    )
                )
            )
        )
    )
)

val sampleTrainingWeeks = listOf(samplePushPullLegsTrainingWeek)
