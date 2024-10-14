package com.maruchin.gymster.data.plans.repository

import app.cash.turbine.test
import com.maruchin.gymster.core.database.di.coreDatabaseTestModule
import com.maruchin.gymster.data.plans.di.dataPlansModule
import com.maruchin.gymster.data.plans.model.Plan
import com.maruchin.gymster.data.plans.model.PlanExercise
import com.maruchin.gymster.data.plans.model.PlanTraining
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject

class DefaultPlansRepositoryTest : KoinTest {

    private val repository: PlansRepository by inject()

    @BeforeTest
    fun setup() {
        startKoin { modules(dataPlansModule, coreDatabaseTestModule) }
    }

    @AfterTest
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun `create plan`() = runTest {
        repository.observeAllPlans().test {
            assertEquals(emptyList(), awaitItem())

            val planId = repository.createPlan(name = "Push Pull")

            assertContentEquals(
                expected = listOf(
                    Plan(
                        id = planId,
                        name = "Push Pull",
                        trainings = emptyList()
                    )
                ),
                actual = awaitItem()
            )
        }
    }

    @Test
    fun `update plan`() = runTest {
        val planId = repository.createPlan(name = "Push Pull")

        repository.observePlan(planId).test {
            assertEquals(
                expected = Plan(
                    id = planId,
                    name = "Push Pull",
                    trainings = emptyList()
                ),
                actual = awaitItem()
            )

            repository.updatePlan(planId, "Push Pull Legs")

            assertEquals(
                expected = Plan(
                    id = planId,
                    name = "Push Pull Legs",
                    trainings = emptyList()
                ),
                actual = awaitItem()
            )
        }
    }

    @Test
    fun `delete plan`() = runTest {
        val planId = repository.createPlan(name = "Push Pull")

        repository.observeAllPlans().test {
            assertContentEquals(
                expected = listOf(
                    Plan(
                        id = planId,
                        name = "Push Pull",
                        trainings = emptyList()
                    )
                ),
                actual = awaitItem()
            )

            repository.deletePlan(planId)

            assertContentEquals(
                expected = emptyList(),
                actual = awaitItem()
            )
        }
    }

    @Test
    fun `add training`() = runTest {
        val planId = repository.createPlan(name = "Push Pull")

        repository.observePlan(planId).test {
            assertEquals(
                expected = Plan(
                    id = planId,
                    name = "Push Pull",
                    trainings = emptyList()
                ),
                actual = awaitItem()
            )

            val trainingId = repository.addTraining(planId, "Push")

            assertEquals(
                expected = Plan(
                    id = planId,
                    name = "Push Pull",
                    trainings = listOf(
                        PlanTraining(
                            id = trainingId,
                            name = "Push",
                            exercises = emptyList()
                        )
                    )
                ),
                actual = awaitItem()
            )
        }
    }

    @Test
    fun `update training`() = runTest {
        val planId = repository.createPlan(name = "Push Pull")
        val trainingId = repository.addTraining(planId, "Push")

        repository.observePlan(planId).test {
            assertEquals(
                expected = Plan(
                    id = planId,
                    name = "Push Pull",
                    trainings = listOf(
                        PlanTraining(
                            id = trainingId,
                            name = "Push",
                            exercises = emptyList()
                        )
                    )
                ),
                actual = awaitItem()
            )

            repository.updateTraining(trainingId, "Pull")

            assertEquals(
                expected = Plan(
                    id = planId,
                    name = "Push Pull",
                    trainings = listOf(
                        PlanTraining(
                            id = trainingId,
                            name = "Pull",
                            exercises = emptyList()
                        )
                    )
                ),
                actual = awaitItem()
            )
        }
    }

    @Test
    fun `delete training`() = runTest {
        val planId = repository.createPlan(name = "Push Pull")
        val trainingId = repository.addTraining(planId, "Push")

        repository.observePlan(planId).test {
            assertEquals(
                expected = Plan(
                    id = planId,
                    name = "Push Pull",
                    trainings = listOf(
                        PlanTraining(
                            id = trainingId,
                            name = "Push",
                            exercises = emptyList()
                        )
                    )
                ),
                actual = awaitItem()
            )

            repository.deleteTraining(trainingId)

            assertEquals(
                expected = Plan(
                    id = planId,
                    name = "Push Pull",
                    trainings = emptyList()
                ),
                actual = awaitItem()
            )
        }
    }

    @Test
    fun `add exercise`() = runTest {
        val planId = repository.createPlan(name = "Push Pull")
        val trainingId = repository.addTraining(planId, "Push")

        repository.observePlan(planId).test {
            assertEquals(
                expected = Plan(
                    id = planId,
                    name = "Push Pull",
                    trainings = listOf(
                        PlanTraining(
                            id = trainingId,
                            name = "Push",
                            exercises = emptyList()
                        )
                    )
                ),
                actual = awaitItem()
            )

            val exerciseId = repository.addExercise(
                trainingId = trainingId,
                name = "Wyciskanie sztangi na ławce poziomej",
                sets = 3,
                reps = 4..6
            )

            assertEquals(
                expected = Plan(
                    id = planId,
                    name = "Push Pull",
                    trainings = listOf(
                        PlanTraining(
                            id = trainingId,
                            name = "Push",
                            exercises = listOf(
                                PlanExercise(
                                    id = exerciseId,
                                    name = "Wyciskanie sztangi na ławce poziomej",
                                    sets = 3,
                                    reps = 4..6
                                )
                            )
                        )
                    )
                ),
                actual = awaitItem()
            )
        }
    }

    @Test
    fun `update exercise`() = runTest {
        val planId = repository.createPlan(name = "Push Pull")
        val trainingId = repository.addTraining(planId, "Push")
        val exerciseId = repository.addExercise(
            trainingId = trainingId,
            name = "Wyciskanie sztangi na ławce poziomej",
            sets = 3,
            reps = 4..6
        )

        repository.observePlan(planId).test {
            assertEquals(
                expected = Plan(
                    id = planId,
                    name = "Push Pull",
                    trainings = listOf(
                        PlanTraining(
                            id = trainingId,
                            name = "Push",
                            exercises = listOf(
                                PlanExercise(
                                    id = exerciseId,
                                    name = "Wyciskanie sztangi na ławce poziomej",
                                    sets = 3,
                                    reps = 4..6
                                )
                            )
                        )
                    )
                ),
                actual = awaitItem()
            )

            repository.updateExercise(
                exerciseId = exerciseId,
                name = "Wyciskanie hantli nad głowę siedząc",
                sets = 2,
                reps = 8..10
            )

            assertEquals(
                expected = Plan(
                    id = planId,
                    name = "Push Pull",
                    trainings = listOf(
                        PlanTraining(
                            id = trainingId,
                            name = "Push",
                            exercises = listOf(
                                PlanExercise(
                                    id = exerciseId,
                                    name = "Wyciskanie hantli nad głowę siedząc",
                                    sets = 2,
                                    reps = 8..10
                                )
                            )
                        )
                    )
                ),
                actual = awaitItem()
            )
        }
    }

    @Test
    fun `delete exercise`() = runTest {
        val planId = repository.createPlan(name = "Push Pull")
        val trainingId = repository.addTraining(planId, "Push")
        val exerciseId = repository.addExercise(
            trainingId = trainingId,
            name = "Wyciskanie sztangi na ławce poziomej",
            sets = 3,
            reps = 4..6
        )

        repository.observePlan(planId).test {
            assertEquals(
                expected = Plan(
                    id = planId,
                    name = "Push Pull",
                    trainings = listOf(
                        PlanTraining(
                            id = trainingId,
                            name = "Push",
                            exercises = listOf(
                                PlanExercise(
                                    id = exerciseId,
                                    name = "Wyciskanie sztangi na ławce poziomej",
                                    sets = 3,
                                    reps = 4..6
                                )
                            )
                        )
                    )
                ),
                actual = awaitItem()
            )

            repository.deleteExercise(exerciseId)

            assertEquals(
                expected = Plan(
                    id = planId,
                    name = "Push Pull",
                    trainings = listOf(
                        PlanTraining(
                            id = trainingId,
                            name = "Push",
                            exercises = emptyList()
                        )
                    )
                ),
                actual = awaitItem()
            )
        }
    }

    @Test
    fun `reorder exercises`() = runTest {
        val planId = repository.createPlan(name = "Push Pull")
        val trainingId = repository.addTraining(planId, "Push")
        val exercise1Id = repository.addExercise(
            trainingId = trainingId,
            name = "Wyciskanie sztangi na ławce poziomej",
            sets = 3,
            reps = 4..6
        )
        val exercise2Id = repository.addExercise(
            trainingId = trainingId,
            name = "Wyciskanie hantli nad głowę siedząc",
            sets = 2,
            reps = 8..10
        )
        val exercise1 = PlanExercise(
            id = exercise1Id,
            name = "Wyciskanie sztangi na ławce poziomej",
            sets = 3,
            reps = 4..6
        )
        val exercise2 = PlanExercise(
            id = exercise2Id,
            name = "Wyciskanie hantli nad głowę siedząc",
            sets = 2,
            reps = 8..10
        )

        repository.observePlan(planId).test {
            assertEquals(
                expected = Plan(
                    id = planId,
                    name = "Push Pull",
                    trainings = listOf(
                        PlanTraining(
                            id = trainingId,
                            name = "Push",
                            exercises = listOf(exercise1, exercise2)
                        )
                    )
                ),
                actual = awaitItem()
            )

            repository.reorderExercises(listOf(exercise2Id, exercise1Id))

            // TODO Think how to do it in one transaction. Now it requires N updates
            assertEquals(
                expected = Plan(
                    id = planId,
                    name = "Push Pull",
                    trainings = listOf(
                        PlanTraining(
                            id = trainingId,
                            name = "Push",
                            exercises = listOf(exercise2, exercise1)
                        )
                    )
                ),
                actual = expectMostRecentItem()
            )
        }
    }
}
