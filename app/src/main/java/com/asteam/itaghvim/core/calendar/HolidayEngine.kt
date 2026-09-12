package com.asteam.itaghvim.core.calendar

/**
 * موتور مناسبت های ثابت تقویم شمسی
 *
 * این کلاس مستقل از Event های کاربر است.
 */
class HolidayEngine {

    fun getHolidays(month: Int, day: Int): List<Holiday> {
        return holidays.filter {
            it.month == month && it.day == day
        }
    }

    fun getAllHolidays(): List<Holiday> = holidays

    private val holidays = listOf(
        Holiday(1, 1, "نوروز", HolidayType.NATIONAL),
        Holiday(1, 2, "نوروز", HolidayType.NATIONAL),
        Holiday(1, 3, "نوروز", HolidayType.NATIONAL),
        Holiday(12, 29, "روز ملی شدن صنعت نفت", HolidayType.NATIONAL)
    )
}
