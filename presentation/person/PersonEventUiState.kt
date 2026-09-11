package com.asteam.itaghvim.presentation.person

import com.asteam.itaghvim.domain.model.CalendarEvent

/**
 * وضعیت نمایش مناسبت‌های یک شخص در UI
 */
data class PersonEventUiState(
    val events: List<CalendarEvent> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)
