package com.maruchin.gymster.core.clock

import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.atTime
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime

fun LocalDate.toMillis(): Long = this.atTime(12, 0)
    .toInstant(TimeZone.currentSystemDefault())
    .toEpochMilliseconds()

fun Long.toLocalDate(): LocalDate = Instant.fromEpochMilliseconds(this)
    .toLocalDateTime(TimeZone.currentSystemDefault())
    .date
