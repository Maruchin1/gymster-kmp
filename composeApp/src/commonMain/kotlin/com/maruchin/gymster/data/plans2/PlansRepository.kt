package com.maruchin.gymster.data.plans2

import com.maruchin.gymster.data.exercises.api.ExerciseBaseInfoApi
import com.maruchin.gymster.data.exercises.mapper.toDomain
import com.maruchin.gymster.data.plans2.api.DayApi
import com.maruchin.gymster.data.plans2.api.SetApi
import com.maruchin.gymster.data.plans2.api.SettingApi
import com.maruchin.gymster.data.plans2.api.WorkoutApi
import com.maruchin.gymster.data.plans2.json.DayJson
import com.maruchin.gymster.data.plans2.json.WorkoutJson
import com.maruchin.gymster.data.plans2.mapper.toDomain
import com.maruchin.gymster.data.plans2.model.ExerciseTemplate
import com.maruchin.gymster.data.plans2.model.Plan
import com.maruchin.gymster.data.plans2.model.WorkoutTemplate
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

internal class PlansRepository(
    private val workoutApi: WorkoutApi,
    private val dayApi: DayApi,
    private val setApi: SetApi,
    private val settingApi: SettingApi,
    private val exerciseBaseInfoApi: ExerciseBaseInfoApi
) {

    suspend fun getAllPlans(): List<Plan> = coroutineScope {
        workoutApi.get().results.map { workoutJson ->
            async {
                workoutJson.toDomain(
                    workouts = getWorkouts(workoutJson)
                )
            }
        }.awaitAll()
    }

    suspend fun getPlanById(planId: Int): Plan? {
        return workoutApi.get(planId)?.let { workoutJson ->
            workoutJson.toDomain(
                workouts = getWorkouts(workoutJson)
            )
        }
    }

    private suspend fun getWorkouts(
        workoutJson: WorkoutJson
    ): List<WorkoutTemplate> = coroutineScope {
        dayApi.get(workoutId = workoutJson.id).results.map { dayJson ->
            async {
                dayJson.toDomain(
                    exercises = getExercises(dayJson)
                )
            }
        }.awaitAll()
    }

    private suspend fun getExercises(
        dayJson: DayJson
    ): List<ExerciseTemplate> = coroutineScope {
        setApi.get(dayId = dayJson.id).results.map { setJson ->
            async {
                val settingListJson = settingApi.get(setId = setJson.id).results
                val firstSettingJson = settingListJson.first()
                val exerciseBaseInfoJson =
                    exerciseBaseInfoApi.get(firstSettingJson.exerciseBase)
                checkNotNull(exerciseBaseInfoJson)
                setJson.toDomain(
                    exerciseBase = exerciseBaseInfoJson.toDomain(),
                    sets = settingListJson.map { it.toDomain() }
                )
            }
        }.awaitAll()
    }
}
