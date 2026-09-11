package com.asteam.itaghvim.core.calendar

/**
 * تامین کننده مناسبت های تقویم
 * لیست مناسبت ها در مراحل بعد تکمیل می شود.
 */
object HolidayProvider {

    private val holidays = mapOf(
        1 to listOf("نوروز")
    )

    fun getHolidays(month: Int): List<String> {
        return holidays[month] ?: emptyList()
    }
}
