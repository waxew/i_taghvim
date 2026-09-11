package com.asteam.itaghvim.presentation.calendar.model

/**
 * مدل پایه تاریخ در تقویم آی تقویم
 * آماده برای نگهداری تاریخ شمسی، قمری و میلادی
 */
data class CalendarDate(
    val day: Int,
    val month: Int,
    val year: Int,
    val calendarType: String
)
