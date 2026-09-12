package com.asteam.itaghvim.presentation.calendar

import com.asteam.itaghvim.domain.model.CalendarEvent

/** وضعیت یکپارچه تقویم، تبدیل تاریخ، رویدادها و بارگذاری. */
data class CalendarUiState(
    val year: Int = 1405,
    val month: Int = 1,
    val selectedDay: Int = 1,
    val solarDate: String = "",
    val lunarDate: String = "",
    val gregorianDate: String = "",
    val events: List<CalendarEvent> = emptyList(),
    val holidays: List<String> = emptyList(),
    val isLoading: Boolean = true,
    val errorMessage: String? = null
)
