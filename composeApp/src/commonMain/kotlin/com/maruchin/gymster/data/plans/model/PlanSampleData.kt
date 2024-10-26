package com.maruchin.gymster.data.plans.model

internal val samplePushPullLegsPlan = Plan(
    id = "1",
    name = "Push Pull Legs",
    isActive = false,
    trainings = listOf(
        PlanTraining(
            id = "1",
            name = "Push",
            exercises = listOf(
                PlanExercise(
                    id = "1",
                    name = "Wyciskanie sztangi na ławce poziomej",
                    sets = 3,
                    reps = 4..6
                ),
                PlanExercise(
                    id = "2",
                    name = "Rozpiętki hantlami na ławce skos dodatni",
                    sets = 3,
                    reps = 10..12
                ),
                PlanExercise(
                    id = "3",
                    name = "Wyciskanie hantlami nad głowę siedząc",
                    sets = 3,
                    reps = 8..10
                ),
                PlanExercise(
                    id = "4",
                    name = "Wznosy hantli bokiem stojąc",
                    sets = 3,
                    reps = 10..20
                ),
                PlanExercise(
                    id = "5",
                    name = "Prostowanie ramion na wyciągu",
                    sets = 3,
                    reps = 10..12
                )
            )
        ),
        PlanTraining(
            id = "2",
            name = "Pull",
            exercises = listOf(
                PlanExercise(
                    id = "6",
                    name = "Wiosłowanie sztangą",
                    sets = 3,
                    reps = 6..8
                ),
                PlanExercise(
                    id = "7",
                    name = "Ściąganie drążka wyciągu górnego chwytem V",
                    sets = 3,
                    reps = 8..10
                ),
                PlanExercise(
                    id = "8",
                    name = "Wisoławanie hantlami w oparciu o ławkę",
                    sets = 2,
                    reps = 10..12
                ),
                PlanExercise(
                    id = "9",
                    name = "Odwrotne rozpiętki hantlami w oparciu o ławkę",
                    sets = 3,
                    reps = 10..20
                ),
                PlanExercise(
                    id = "10",
                    name = "Uginanie hantli na modlitewniku",
                    sets = 3,
                    reps = 10..12
                )
            )
        ),
        PlanTraining(
            id = "3",
            name = "Legs",
            exercises = listOf(
                PlanExercise(
                    id = "11",
                    name = "Przysiad ze sztangą z tyłu",
                    sets = 3,
                    reps = 4..6
                ),
                PlanExercise(
                    id = "12",
                    name = "Wypychanie nóg na suwnicy",
                    sets = 3,
                    reps = 8..10
                ),
                PlanExercise(
                    id = "13",
                    name = "Uginanie nóg leżąc na maszynie",
                    sets = 3,
                    reps = 10..12
                ),
                PlanExercise(
                    id = "14",
                    name = "Wyprosty tułowia na ławce rzymskiej",
                    sets = 3,
                    reps = 10..12
                ),
                PlanExercise(
                    id = "15",
                    name = "Wspięcia na palce na suwnicy",
                    sets = 3,
                    reps = 10..20
                )
            )
        )
    )
)

internal val samplePushPullLegsPlanActive = samplePushPullLegsPlan.copy(isActive = true)

internal val sampleFullBodyWorkoutEmptyPlan = Plan(
    id = "2",
    name = "Full Body Workout",
    isActive = false,
    trainings = emptyList()
)

internal val samplePlans = listOf(samplePushPullLegsPlan, sampleFullBodyWorkoutEmptyPlan)
