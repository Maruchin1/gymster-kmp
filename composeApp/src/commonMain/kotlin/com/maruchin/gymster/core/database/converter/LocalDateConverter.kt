package com.maruchin.gymster.core.database.converter

import androidx.room.TypeConverter
import kotlinx.datetime.LocalDate

class LocalDateConverter {

    @TypeConverter
    fun localDateToString(localDate: LocalDate) = localDate.toString()

    @TypeConverter
    fun stringToLocalDate(string: String) = LocalDate.parse(string)
}
