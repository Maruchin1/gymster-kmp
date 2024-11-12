package com.maruchin.gymster.data.trainings

import com.maruchin.gymster.data.trainings.api.DayApi
import com.maruchin.gymster.data.trainings.api.ExerciseApi
import com.maruchin.gymster.data.trainings.api.SetApi
import com.maruchin.gymster.data.trainings.api.SettingApi
import com.maruchin.gymster.data.trainings.mapper.toDomain
import com.maruchin.gymster.data.trainings.mapper.toJson
import com.maruchin.gymster.data.trainings.mapper.toSetRequestJson
import com.maruchin.gymster.data.trainings.mapper.toSettingRequestJson
import com.maruchin.gymster.data.trainings.model.AddExerciseRequest
import com.maruchin.gymster.data.trainings.model.AddTrainingRequest
import com.maruchin.gymster.data.trainings.model.EditTrainingRequest
import com.maruchin.gymster.data.trainings.model.Training
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

internal class TrainingsRepository(
    private val dayApi: DayApi,
    private val setApi: SetApi,
    private val settingApi: SettingApi,
    private val exerciseApi: ExerciseApi
) {

    suspend fun getTrainings(planId: Int): List<Training> = coroutineScope {
        dayApi.getDays(planId).map { dayJson ->
            async {
                val exercises = getExercises(dayJson.id)
                dayJson.toDomain(exercises)
            }
        }.awaitAll()
    }

    private suspend fun getExercises(trainingId: Int) = coroutineScope {
        setApi.getSets(trainingId).map { setJson ->
            async {
                val settingListJson = settingApi.getSettings(setJson.id)
                val exerciseId = settingListJson.first().exerciseBase
                val exerciseJson = exerciseApi.getExercise(exerciseId)
                setJson.toDomain(settingListJson, exerciseJson)
            }
        }.awaitAll()
    }

    suspend fun addTraining(request: AddTrainingRequest) {
        dayApi.addDay(request.toJson())
    }

    suspend fun editTraining(request: EditTrainingRequest) {
        dayApi.updateDay(request.id, request.toJson())
    }

    suspend fun deleteTraining(trainingId: Int) {
        dayApi.deleteDay(trainingId)
    }

    suspend fun addExercise(request: AddExerciseRequest) {
        val setJson = setApi.addSet(request.toSetRequestJson())
        request.toSettingRequestJson(setJson).forEach { settingRequestJson ->
            settingApi.addSetting(settingRequestJson)
        }
    }
}
