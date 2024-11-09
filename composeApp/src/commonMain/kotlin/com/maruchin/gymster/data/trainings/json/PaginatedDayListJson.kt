package com.maruchin.gymster.data.trainings.json

import kotlinx.serialization.Serializable

@Serializable
internal data class PaginatedDayListJson(val results: List<DayJson>)
