package com.asteam.itaghvim.core.calendar

import java.time.DayOfWeek
import java.time.LocalDate

/**
 * تبدیل تاریخ های تقویم
 * نسخه پایه برای توسعه تبدیل شمسی و میلادی
 */
object DateConverter {

    fun gregorianToPersian(date: LocalDate): PersianDate {
        return PersianDate(
            year = date.year - 621,
            month = date.monthValue,
            day = date.dayOfMonth
        )
    }

    fun dayOfWeek(date: LocalDate): Int {
        return when (date.dayOfWeek) {
            DayOfWeek.SATURDAY -> 0
            DayOfWeek.SUNDAY -> 1
            DayOfWeek.MONDAY -> 2
            DayOfWeek.TUESDAY -> 3
            DayOfWeek.WEDNESDAY -> 4
            DayOfWeek.THURSDAY -> 5
            DayOfWeek.FRIDAY -> 6
        }
    }

    data class PersianDate(
        val year: Int,
        val month: Int,
        val day: Int
    )
}
