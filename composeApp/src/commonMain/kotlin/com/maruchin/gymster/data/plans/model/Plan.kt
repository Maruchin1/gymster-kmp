package com.maruchin.gymster.data.plans.model

import kotlinx.datetime.LocalDate

internal data class Plan(val id: Int, val name: String, val creationDate: LocalDate)
