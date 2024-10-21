package com.maruchin.gymster.core.utils.clock

import kotlinx.datetime.LocalDate
import kotlinx.datetime.format.MonthNames
import kotlinx.datetime.format.char

val localDateShortFormat = LocalDate.Format {
    dayOfMonth()
    char(' ')
    monthName(MonthNames.ENGLISH_ABBREVIATED)
    char(' ')
    year()
}

val localDateFullFormat = LocalDate.Format {
    monthName(MonthNames.ENGLISH_FULL)
    char(' ')
    dayOfMonth()
    char(' ')
    year()
}
