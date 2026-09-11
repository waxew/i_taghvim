package com.asteam.itaghvim.core.calendar

/**
 * محاسبات مرتبط با ماه تقویم شمسی
 */
object MonthCalculator {

    fun monthName(month: Int): String {
        return when(month) {
            1 -> "فروردین"
            2 -> "اردیبهشت"
            3 -> "خرداد"
            4 -> "تیر"
            5 -> "مرداد"
            6 -> "شهریور"
            7 -> "مهر"
            8 -> "آبان"
            9 -> "آذر"
            10 -> "دی"
            11 -> "بهمن"
            12 -> "اسفند"
            else -> ""
        }
    }

    fun daysOfMonth(year: Int, month: Int): Int {
        return PersianCalendar.daysInMonth(month, year)
    }

    fun monthRange(year: Int, month: Int): IntRange {
        return 1..daysOfMonth(year, month)
    }
}
