package com.asteam.itaghvim.core.calendar

/**
 * مدل پایه مناسبت های تقویمی
 */
data class Holiday(
    val month: Int,
    val day: Int,
    val title: String,
    val type: HolidayType = HolidayType.NORMAL
)

enum class HolidayType {
    NORMAL,
    NATIONAL,
    RELIGIOUS,
    INTERNATIONAL
}
