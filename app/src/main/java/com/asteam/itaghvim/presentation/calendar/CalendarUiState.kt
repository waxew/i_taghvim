package com.asteam.itaghvim.presentation.calendar

/**
 * وضعیت نمایشی صفحه تقویم
 */
data class CalendarUiState(
    val selectedDay: String = "",
    val solarDate: String = "",
    val lunarDate: String = "",
    val gregorianDate: String = ""
)
