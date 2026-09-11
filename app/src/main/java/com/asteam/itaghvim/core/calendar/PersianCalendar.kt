package com.asteam.itaghvim.core.calendar

/**
 * موتور پایه تقویم شمسی
 * در این بخش محاسبات تاریخ شمسی توسعه داده می شود.
 */
object PersianCalendar {

    fun daysInMonth(month: Int, year: Int): Int {
        return when {
            month in 1..6 -> 31
            month in 7..11 -> 30
            month == 12 && isLeapYear(year) -> 30
            else -> 29
        }
    }

    fun isLeapYear(year: Int): Boolean {
        return year % 4 == 3
    }
}
