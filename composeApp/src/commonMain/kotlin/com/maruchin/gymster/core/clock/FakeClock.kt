package com.maruchin.gymster.core.clock

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.atTime
import kotlinx.datetime.toInstant

internal class FakeClock : Clock {

    private var now: Instant = Clock.System.now()

    override fun now(): Instant = now

    fun setNow(localDate: LocalDate) {
        now = localDate.atTime(hour = 12, minute = 0, second = 0)
            .toInstant(TimeZone.currentSystemDefault())
    }
}
