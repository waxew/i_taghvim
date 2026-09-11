package com.asteam.itaghvim.core.calendar

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

    data class PersianDate(
        val year: Int,
        val month: Int,
        val day: Int
    )
}
