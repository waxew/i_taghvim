package com.asteam.itaghvim.core.calendar

import java.time.LocalDate

/**
 * توابع کمکی تبدیل تاریخ برای ViewModel و UI.
 */
object DateConverter {

    fun gregorianToPersian(date: LocalDate): PersianDate {
        val value = CalendarConverter.gregorianToSolar(date.year, date.monthValue, date.dayOfMonth)
            .split('/')
        return PersianDate(value[0].toInt(), value[1].toInt(), value[2].toInt())
    }

    /** شنبه صفر است تا چیدمان تقویم فارسی مستقیماً قابل استفاده باشد. */
    fun dayOfWeek(date: LocalDate): Int {
        return when (date.dayOfWeek) {
            java.time.DayOfWeek.SATURDAY -> 0
            java.time.DayOfWeek.SUNDAY -> 1
            java.time.DayOfWeek.MONDAY -> 2
            java.time.DayOfWeek.TUESDAY -> 3
            java.time.DayOfWeek.WEDNESDAY -> 4
            java.time.DayOfWeek.THURSDAY -> 5
            java.time.DayOfWeek.FRIDAY -> 6
        }
    }

    data class PersianDate(
        val year: Int,
        val month: Int,
        val day: Int
    )
}
