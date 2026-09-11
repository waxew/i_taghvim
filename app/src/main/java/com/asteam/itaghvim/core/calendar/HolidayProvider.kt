package com.asteam.itaghvim.core.calendar

/**
 * تامین کننده مناسبت های تقویم
 * مدیریت مناسبت های ثابت تقویم شمسی
 */
object HolidayProvider {

    private val holidays = mapOf(
        1 to listOf(
            "نوروز",
            "روز جمهوری اسلامی ایران"
        ),
        2 to listOf(
            "روز معلم"
        ),
        3 to listOf(
            "روز جهانی کارگر"
        ),
        4 to listOf(
            "روز قلم"
        ),
        7 to listOf(
            "روز حافظ"
        ),
        11 to listOf(
            "روز دانش آموز"
        ),
        12 to listOf(
            "شب یلدا"
        )
    )

    fun getHolidays(month: Int): List<String> {
        return holidays[month] ?: emptyList()
    }
}
