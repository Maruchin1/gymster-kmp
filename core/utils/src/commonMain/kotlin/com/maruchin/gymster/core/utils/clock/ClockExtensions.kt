package com.maruchin.gymster.core.utils.clock

import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

fun Clock.currentDate() = now().toLocalDateTime(TimeZone.currentSystemDefault()).date
