package com.maruchin.gymster.data.plans2

import com.maruchin.gymster.data.exercises.api.ExerciseBaseInfoApi
import com.maruchin.gymster.data.exercises.mapper.toDomain
import com.maruchin.gymster.data.plans2.api.DayApi
import com.maruchin.gymster.data.plans2.api.SetApi
import com.maruchin.gymster.data.plans2.api.SettingApi
import com.maruchin.gymster.data.plans2.api.WorkoutApi
import com.maruchin.gymster.data.plans2.json.DayJson
import com.maruchin.gymster.data.plans2.json.WorkoutJson
import com.maruchin.gymster.data.plans2.json.toJson
import com.maruchin.gymster.data.plans2.mapper.toDomain
import com.maruchin.gymster.data.plans2.mapper.toJson
import com.maruchin.gymster.data.plans2.model.AddPlanRequest
import com.maruchin.gymster.data.plans2.model.AddWorkoutRequest
import com.maruchin.gymster.data.plans2.model.ExerciseTemplate
import com.maruchin.gymster.data.plans2.model.Plan
import com.maruchin.gymster.data.plans2.model.RenamePlanRequest
import com.maruchin.gymster.data.plans2.model.RenameWorkoutTemplateRequest
import com.maruchin.gymster.data.plans2.model.WorkoutTemplate
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

@Suppress("TooManyFunctions")
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

    suspend fun getWorkoutTemplateById(workoutId: Int): WorkoutTemplate? {
        return dayApi.get(id = workoutId)?.let { dayJson ->
            dayJson.toDomain(
                exercises = getExercises(dayJson)
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

    suspend fun addPlan(request: AddPlanRequest) {
        workoutApi.post(body = request.toJson())
    }

    suspend fun deletePlan(planId: Int) {
        workoutApi.delete(planId)
    }

    suspend fun renamePlan(request: RenamePlanRequest) {
        workoutApi.patch(id = request.id, body = request.toJson())
    }

    suspend fun addWorkout(request: AddWorkoutRequest) {
        dayApi.post(body = request.toJson())
    }

    suspend fun renameWorkoutTemplate(request: RenameWorkoutTemplateRequest) {
        dayApi.patch(id = request.workoutTemplateId, body = request.toJson())
    }

    suspend fun deleteWorkoutTemplate(workoutTemplateId: Int) {
        dayApi.delete(id = workoutTemplateId)
    }
}
