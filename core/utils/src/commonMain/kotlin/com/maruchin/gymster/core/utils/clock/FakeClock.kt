package com.maruchin.gymster.core.utils.clock

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.atTime
import kotlinx.datetime.toInstant

class FakeClock : Clock {

    private var now: Instant = Clock.System.now()

    override fun now(): Instant = now

    fun setNow(localDate: LocalDate) {
        now = localDate.atTime(12, 0, 0).toInstant(TimeZone.currentSystemDefault())
    }
}
