package com.maruchin.gymster.data.trainings.repository

import app.cash.turbine.test
import com.maruchin.gymster.core.database.di.coreDatabaseTestModule
import com.maruchin.gymster.core.utils.clock.FakeClock
import com.maruchin.gymster.core.utils.di.coreClockTestModule
import com.maruchin.gymster.data.plans.model.samplePushPullLegsPlanActive
import com.maruchin.gymster.data.trainings.di.dataTrainingsModule
import com.maruchin.gymster.data.trainings.model.Exercise
import com.maruchin.gymster.data.trainings.model.SetResult
import com.maruchin.gymster.data.trainings.model.Training
import com.maruchin.gymster.data.trainings.model.TrainingWeek
import io.kotest.matchers.shouldBe
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlinx.coroutines.test.runTest
import kotlinx.datetime.LocalDate
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject

class DefaultTrainingsRepositoryTest : KoinTest {

    private val clock: FakeClock by inject()
    private val repository: TrainingsRepository by inject()

    private val currentDate = LocalDate(2024, 10, 21)

    @BeforeTest
    fun setup() {
        startKoin { modules(dataTrainingsModule, coreDatabaseTestModule, coreClockTestModule) }
        clock.setNow(currentDate)
    }

    @AfterTest
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun `start new training`() = runTest {
        repository.observeCurrentTrainingWeek().test {
            awaitItem() shouldBe null

            val createdTrainingWeek = repository.startNewWeek(samplePushPullLegsPlanActive)
            expectMostRecentItem() shouldBe TrainingWeek(
                id = createdTrainingWeek.id,
                startDate = currentDate,
                trainings = listOf(
                    Training(
                        id = createdTrainingWeek.trainings[0].id,
                        name = "Push",
                        exercises = listOf(
                            Exercise(
                                id = createdTrainingWeek.trainings[0].exercises[0].id,
                                name = "Wyciskanie sztangi na ławce poziomej",
                                sets = 3,
                                reps = 4..6,
                                setsResults = listOf(
                                    SetResult(
                                        id = createdTrainingWeek.trainings[0].exercises[0]
                                            .setsResults[0].id
                                    ),
                                    SetResult(
                                        id = createdTrainingWeek.trainings[0].exercises[0]
                                            .setsResults[1].id
                                    ),
                                    SetResult(
                                        id = createdTrainingWeek.trainings[0].exercises[0]
                                            .setsResults[2].id
                                    )
                                )
                            ),
                            Exercise(
                                id = createdTrainingWeek.trainings[0].exercises[1].id,
                                name = "Rozpiętki hantlami na ławce skos dodatni",
                                sets = 3,
                                reps = 10..12,
                                setsResults = listOf(
                                    SetResult(
                                        id = createdTrainingWeek.trainings[0].exercises[1]
                                            .setsResults[0].id
                                    ),
                                    SetResult(
                                        id = createdTrainingWeek.trainings[0].exercises[1]
                                            .setsResults[1].id
                                    ),
                                    SetResult(
                                        id = createdTrainingWeek.trainings[0].exercises[1]
                                            .setsResults[2].id
                                    )
                                )
                            ),
                            Exercise(
                                id = createdTrainingWeek.trainings[0].exercises[2].id,
                                name = "Wyciskanie hantlami nad głowę siedząc",
                                sets = 3,
                                reps = 8..10,
                                setsResults = listOf(
                                    SetResult(
                                        id = createdTrainingWeek.trainings[0].exercises[2]
                                            .setsResults[0].id
                                    ),
                                    SetResult(
                                        id = createdTrainingWeek.trainings[0].exercises[2]
                                            .setsResults[1].id
                                    ),
                                    SetResult(
                                        id = createdTrainingWeek.trainings[0].exercises[2]
                                            .setsResults[2].id
                                    )
                                )
                            ),
                            Exercise(
                                id = createdTrainingWeek.trainings[0].exercises[3].id,
                                name = "Wznosy hantli bokiem stojąc",
                                sets = 3,
                                reps = 10..20,
                                setsResults = listOf(
                                    SetResult(
                                        id = createdTrainingWeek.trainings[0].exercises[3]
                                            .setsResults[0].id
                                    ),
                                    SetResult(
                                        id = createdTrainingWeek.trainings[0].exercises[3]
                                            .setsResults[1].id
                                    ),
                                    SetResult(
                                        id = createdTrainingWeek.trainings[0].exercises[3]
                                            .setsResults[2].id
                                    )
                                )
                            ),
                            Exercise(
                                id = createdTrainingWeek.trainings[0].exercises[4].id,
                                name = "Prostowanie ramion na wyciągu",
                                sets = 3,
                                reps = 10..12,
                                setsResults = listOf(
                                    SetResult(
                                        id = createdTrainingWeek.trainings[0].exercises[4]
                                            .setsResults[0].id
                                    ),
                                    SetResult(
                                        id = createdTrainingWeek.trainings[0].exercises[4]
                                            .setsResults[1].id
                                    ),
                                    SetResult(
                                        id = createdTrainingWeek.trainings[0].exercises[4]
                                            .setsResults[2].id
                                    )
                                )
                            )
                        )
                    ),
                    Training(
                        id = createdTrainingWeek.trainings[1].id,
                        name = "Pull",
                        exercises = listOf(
                            Exercise(
                                id = createdTrainingWeek.trainings[1].exercises[0].id,
                                name = "Wiosłowanie sztangą",
                                sets = 3,
                                reps = 6..8,
                                setsResults = listOf(
                                    SetResult(
                                        id = createdTrainingWeek.trainings[1].exercises[0]
                                            .setsResults[0].id
                                    ),
                                    SetResult(
                                        id = createdTrainingWeek.trainings[1].exercises[0]
                                            .setsResults[1].id
                                    ),
                                    SetResult(
                                        id = createdTrainingWeek.trainings[1].exercises[0]
                                            .setsResults[2].id
                                    )
                                )
                            ),
                            Exercise(
                                id = createdTrainingWeek.trainings[1].exercises[1].id,
                                name = "Ściąganie drążka wyciągu górnego chwytem V",
                                sets = 3,
                                reps = 8..10,
                                setsResults = listOf(
                                    SetResult(
                                        id = createdTrainingWeek.trainings[1].exercises[1]
                                            .setsResults[0].id
                                    ),
                                    SetResult(
                                        id = createdTrainingWeek.trainings[1].exercises[1]
                                            .setsResults[1].id
                                    ),
                                    SetResult(
                                        id = createdTrainingWeek.trainings[1].exercises[1]
                                            .setsResults[2].id
                                    )
                                )
                            ),
                            Exercise(
                                id = createdTrainingWeek.trainings[1].exercises[2].id,
                                name = "Wisoławanie hantlami w oparciu o ławkę",
                                sets = 2,
                                reps = 10..12,
                                setsResults = listOf(
                                    SetResult(
                                        id = createdTrainingWeek.trainings[1].exercises[2]
                                            .setsResults[0].id
                                    ),
                                    SetResult(
                                        id = createdTrainingWeek.trainings[1].exercises[2]
                                            .setsResults[1].id
                                    )
                                )
                            ),
                            Exercise(
                                id = createdTrainingWeek.trainings[1].exercises[3].id,
                                name = "Odwrotne rozpiętki hantlami w oparciu o ławkę",
                                sets = 3,
                                reps = 10..20,
                                setsResults = listOf(
                                    SetResult(
                                        id = createdTrainingWeek.trainings[1].exercises[3]
                                            .setsResults[0].id
                                    ),
                                    SetResult(
                                        id = createdTrainingWeek.trainings[1].exercises[3]
                                            .setsResults[1].id
                                    ),
                                    SetResult(
                                        id = createdTrainingWeek.trainings[1].exercises[3]
                                            .setsResults[2].id
                                    )
                                )
                            ),
                            Exercise(
                                id = createdTrainingWeek.trainings[1].exercises[4].id,
                                name = "Uginanie hantli na modlitewniku",
                                sets = 3,
                                reps = 10..12,
                                setsResults = listOf(
                                    SetResult(
                                        id = createdTrainingWeek.trainings[1].exercises[4]
                                            .setsResults[0].id
                                    ),
                                    SetResult(
                                        id = createdTrainingWeek.trainings[1].exercises[4]
                                            .setsResults[1].id
                                    ),
                                    SetResult(
                                        id = createdTrainingWeek.trainings[1].exercises[4]
                                            .setsResults[2].id
                                    )
                                )
                            )
                        )
                    ),
                    Training(
                        id = createdTrainingWeek.trainings[2].id,
                        name = "Legs",
                        exercises = listOf(
                            Exercise(
                                id = createdTrainingWeek.trainings[2].exercises[0].id,
                                name = "Przysiad ze sztangą z tyłu",
                                sets = 3,
                                reps = 4..6,
                                setsResults = listOf(
                                    SetResult(
                                        id = createdTrainingWeek.trainings[2].exercises[0]
                                            .setsResults[0].id
                                    ),
                                    SetResult(
                                        id = createdTrainingWeek.trainings[2].exercises[0]
                                            .setsResults[1].id
                                    ),
                                    SetResult(
                                        id = createdTrainingWeek.trainings[2].exercises[0]
                                            .setsResults[2].id
                                    )
                                )
                            ),
                            Exercise(
                                id = createdTrainingWeek.trainings[2].exercises[1].id,
                                name = "Wypychanie nóg na suwnicy",
                                sets = 3,
                                reps = 8..10,
                                setsResults = listOf(
                                    SetResult(
                                        id = createdTrainingWeek.trainings[2].exercises[1]
                                            .setsResults[0].id
                                    ),
                                    SetResult(
                                        id = createdTrainingWeek.trainings[2].exercises[1]
                                            .setsResults[1].id
                                    ),
                                    SetResult(
                                        id = createdTrainingWeek.trainings[2].exercises[1]
                                            .setsResults[2].id
                                    )
                                )
                            ),
                            Exercise(
                                id = createdTrainingWeek.trainings[2].exercises[2].id,
                                name = "Uginanie nóg leżąc na maszynie",
                                sets = 3,
                                reps = 10..12,
                                setsResults = listOf(
                                    SetResult(
                                        id = createdTrainingWeek.trainings[2].exercises[2]
                                            .setsResults[0].id
                                    ),
                                    SetResult(
                                        id = createdTrainingWeek.trainings[2].exercises[2]
                                            .setsResults[1].id
                                    ),
                                    SetResult(
                                        id = createdTrainingWeek.trainings[2].exercises[2]
                                            .setsResults[2].id
                                    )
                                )
                            ),
                            Exercise(
                                id = createdTrainingWeek.trainings[2].exercises[3].id,
                                name = "Wyprosty tułowia na ławce rzymskiej",
                                sets = 3,
                                reps = 10..12,
                                setsResults = listOf(
                                    SetResult(
                                        id = createdTrainingWeek.trainings[2].exercises[3]
                                            .setsResults[0].id
                                    ),
                                    SetResult(
                                        id = createdTrainingWeek.trainings[2].exercises[3]
                                            .setsResults[1].id
                                    ),
                                    SetResult(
                                        id = createdTrainingWeek.trainings[2].exercises[3]
                                            .setsResults[2].id
                                    )
                                )
                            ),
                            Exercise(
                                id = createdTrainingWeek.trainings[2].exercises[4].id,
                                name = "Wspięcia na palce na suwnicy",
                                sets = 3,
                                reps = 10..20,
                                setsResults = listOf(
                                    SetResult(
                                        id = createdTrainingWeek.trainings[2].exercises[4]
                                            .setsResults[0].id
                                    ),
                                    SetResult(
                                        id = createdTrainingWeek.trainings[2].exercises[4]
                                            .setsResults[1].id
                                    ),
                                    SetResult(
                                        id = createdTrainingWeek.trainings[2].exercises[4]
                                            .setsResults[2].id
                                    )
                                )
                            )
                        )
                    )
                )
            )
        }
    }

    @Test
    fun `update set result`() = runTest {
        val createdTrainingWeek = repository.startNewWeek(samplePushPullLegsPlanActive)
        val selectedTraining = createdTrainingWeek.trainings[0]
        val selectedExercise = selectedTraining.exercises[0]
        val selectedSetResult = selectedExercise.setsResults[0]

        repository.observeTraining(selectedTraining.id).test {
            awaitItem()!!.getSetResult(selectedSetResult.id) shouldBe selectedSetResult

            repository.updateSetResult(
                setResultId = selectedSetResult.id,
                weight = 100.0,
                reps = 6
            )

            awaitItem()!!.getSetResult(selectedSetResult.id) shouldBe selectedSetResult.copy(
                weight = 100.0,
                reps = 6
            )
        }
    }
}
