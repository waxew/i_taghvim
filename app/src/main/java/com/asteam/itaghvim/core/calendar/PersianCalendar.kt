package com.asteam.itaghvim.core.calendar

/**
 * موتور پایه تقویم شمسی
 */
object PersianCalendar {

    fun daysInMonth(month: Int, year: Int): Int {
        return when {
            month in 1..6 -> 31
            month in 7..11 -> 30
            month == 12 && isLeapYear(year) -> 30
            month == 12 -> 29
            else -> 0
        }
    }

    fun daysInYear(year: Int): Int {
        return if (isLeapYear(year)) 366 else 365
    }

    fun isLeapYear(year: Int): Boolean {
        val remainder = year % 33
        return remainder == 1 || remainder == 5 || remainder == 9 ||
            remainder == 13 || remainder == 17 || remainder == 22 ||
            remainder == 26 || remainder == 30
    }

    fun isValidDate(year: Int, month: Int, day: Int): Boolean {
        return month in 1..12 && day in 1..daysInMonth(month, year)
    }
}
