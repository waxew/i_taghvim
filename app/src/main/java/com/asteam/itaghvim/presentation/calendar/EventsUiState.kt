package com.asteam.itaghvim.presentation.calendar

import com.asteam.itaghvim.domain.model.CalendarEvent

/**
 * وضعیت نمایش لیست مناسبت ها در رابط کاربری
 */
data class EventsUiState(
    val events: List<CalendarEvent> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)
