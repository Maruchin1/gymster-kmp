package com.maruchin.gymster.data.trainings

import com.maruchin.gymster.data.trainings.api.DayApi
import com.maruchin.gymster.data.trainings.api.ExerciseApi
import com.maruchin.gymster.data.trainings.api.SetApi
import com.maruchin.gymster.data.trainings.api.SettingApi
import com.maruchin.gymster.data.trainings.mapper.toDomain
import com.maruchin.gymster.data.trainings.mapper.toJson
import com.maruchin.gymster.data.trainings.model.AddExerciseRequest
import com.maruchin.gymster.data.trainings.model.AddSetRequest
import com.maruchin.gymster.data.trainings.model.AddTrainingRequest
import com.maruchin.gymster.data.trainings.model.EditSetRequest
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
        setApi.getSets(trainingId).sortedBy { it.order }.map { setJson ->
            async {
                val settingListJson = settingApi.getSettings(setJson.id)
                val firstSettingJson = settingListJson.firstOrNull() ?: return@async null
                val exerciseJson = exerciseApi.getExercise(firstSettingJson.exerciseBase)
                setJson.toDomain(settingListJson, exerciseJson)
            }
        }.awaitAll().filterNotNull()
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
        val setJson = setApi.addSet(request.toJson())
        val addSetRequest = AddSetRequest(
            exerciseId = setJson.id,
            exerciseBaseId = request.exerciseBaseId
        )
        addSet(addSetRequest)
    }

    suspend fun addSet(request: AddSetRequest) {
        settingApi.addSetting(request.toJson())
    }

    suspend fun editSet(request: EditSetRequest) {
        settingApi.updateSetting(request.id, request.toJson())
    }

    suspend fun deleteSet(setId: Int) {
        settingApi.deleteSetting(setId)
    }
}
