package com.asteam.itaghvim.core.calendar

import java.time.LocalDate
import kotlin.math.ceil
import kotlin.math.min

/**
 * مبدل تاریخ‌های شمسی، میلادی و قمری.
 *
 * الگوریتم‌های این فایل مستقل از UI هستند تا همهٔ بخش‌های برنامه
 * یک منبع واحد برای تبدیل تاریخ داشته باشند.
 */
object CalendarConverter {

    private val gregorianDays = intArrayOf(
        31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    )
    private val jalaliDays = intArrayOf(
        31, 31, 31, 31, 31, 31, 30, 30, 30, 30, 30, 29
    )

    /** تبدیل تاریخ میلادی به تاریخ شمسی به شکل yyyy/MM/dd */
    fun gregorianToSolar(year: Int, month: Int, day: Int): String {
        val (jy, jm, jd) = gregorianToJalali(year, month, day)
        return format(jy, jm, jd)
    }

    /** تبدیل تاریخ شمسی به تاریخ میلادی به شکل yyyy/MM/dd */
    fun solarToGregorian(year: Int, month: Int, day: Int): String {
        val (gy, gm, gd) = jalaliToGregorian(year, month, day)
        return format(gy, gm, gd)
    }

    /** تبدیل تاریخ میلادی به تاریخ قمری (تقویم مدنی) به شکل yyyy/MM/dd */
    fun gregorianToLunar(year: Int, month: Int, day: Int): String {
        val julianDay = gregorianToJulianDay(year, month, day)
        val lunarYear = (30 * (julianDay - 1_948_439) + 10_646) / 10_631
        val lunarMonth = min(
            12,
            ceil((julianDay - (29 + islamicToJulianDay(lunarYear, 1, 1)) / 29.5) + 1)
                .toInt()
        )
        val lunarDay = julianDay - islamicToJulianDay(lunarYear, lunarMonth, 1) + 1
        return format(lunarYear, lunarMonth, lunarDay)
    }

    /** تبدیل شمسی به قمری با عبور از تاریخ میلادی متناظر */
    fun solarToLunar(year: Int, month: Int, day: Int): String {
        val gregorian = solarToGregorian(year, month, day).split('/')
        return gregorianToLunar(
            gregorian[0].toInt(),
            gregorian[1].toInt(),
            gregorian[2].toInt()
        )
    }

    /** اولین روز هفتهٔ ماه شمسی؛ شنبه صفر و جمعه شش است. */
    fun firstWeekdayOfSolarMonth(year: Int, month: Int): Int {
        val gregorian = solarToGregorian(year, month, 1).split('/')
        val date = LocalDate.of(gregorian[0].toInt(), gregorian[1].toInt(), gregorian[2].toInt())
        return DateConverter.dayOfWeek(date)
    }

    // نام‌های قدیمی برای سازگاری با کدهای موجود.
    fun convertToSolar(year: Int, month: Int, day: Int): String =
        gregorianToSolar(year, month, day)

    fun convertToGregorian(year: Int, month: Int, day: Int): String =
        solarToGregorian(year, month, day)

    fun convertToLunar(year: Int, month: Int, day: Int): String =
        solarToLunar(year, month, day)

    private fun format(year: Int, month: Int, day: Int): String =
        "%04d/%02d/%02d".format(year, month, day)

    private fun gregorianToJalali(gy: Int, gm: Int, gd: Int): IntArray {
        var year = gy
        var jalaliYear = if (gy > 1600) 979 else 0
        year = if (gy > 1600) gy - 1600 else gy - 621

        var dayNumber = 365 * year + (year + 3) / 4 -
            (year + 99) / 100 + (year + 399) / 400
        for (index in 0 until gm - 1) dayNumber += gregorianDays[index]
        if (gm > 2 && isGregorianLeap(gy)) dayNumber++
        dayNumber += gd - 80

        jalaliYear += 33 * (dayNumber / 12_053)
        dayNumber %= 12_053
        jalaliYear += 4 * (dayNumber / 1_461)
        dayNumber %= 1_461
        if (dayNumber > 365) {
            jalaliYear += (dayNumber - 1) / 365
            dayNumber = (dayNumber - 1) % 365
        }
        val jalaliMonth = if (dayNumber < 186) {
            1 + dayNumber / 31
        } else {
            7 + (dayNumber - 186) / 30
        }
        val jalaliDay = 1 + if (dayNumber < 186) {
            dayNumber % 31
        } else {
            (dayNumber - 186) % 30
        }
        return intArrayOf(jalaliYear, jalaliMonth, jalaliDay)
    }

    private fun jalaliToGregorian(jy: Int, jm: Int, jd: Int): IntArray {
        val jalaliYear = if (jy > 979) jy - 979 else jy
        var gregorianYear = if (jy > 979) 1600 else 621

        var dayNumber = 365 * jalaliYear + (jalaliYear / 33) * 8 +
            ((jalaliYear % 33 + 3) / 4)
        for (index in 0 until jm - 1) dayNumber += jalaliDays[index]
        dayNumber += jd - 1

        dayNumber += 79
        gregorianYear += 400 * (dayNumber / 146_097)
        dayNumber %= 146_097

        var leap = true
        if (dayNumber >= 36_525) {
            dayNumber--
            gregorianYear += 100 * (dayNumber / 36_524)
            dayNumber %= 36_524
            if (dayNumber >= 365) dayNumber++ else leap = false
        }
        gregorianYear += 4 * (dayNumber / 1_461)
        dayNumber %= 1_461
        if (dayNumber >= 366) {
            leap = false
            dayNumber--
            gregorianYear += dayNumber / 365
            dayNumber %= 365
        }

        var month = 0
        val monthDays = gregorianDays.copyOf()
        if (leap) monthDays[1] = 29
        while (month < 12 && dayNumber >= monthDays[month]) {
            dayNumber -= monthDays[month]
            month++
        }
        return intArrayOf(gregorianYear, month + 1, dayNumber + 1)
    }

    private fun isGregorianLeap(year: Int): Boolean =
        year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)

    private fun gregorianToJulianDay(year: Int, month: Int, day: Int): Int {
        val a = (14 - month) / 12
        val y = year + 4_800 - a
        val m = month + 12 * a - 3
        return day + (153 * m + 2) / 5 + 365 * y + y / 4 - y / 100 + y / 400 - 32_045
    }

    private fun islamicToJulianDay(year: Int, month: Int, day: Int): Int =
        day + ceil(29.5 * (month - 1)).toInt() +
            (year - 1) * 354 + (3 + 11 * year) / 30 + 1_948_439 - 1
}
