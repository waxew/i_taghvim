package com.asteam.itaghvim.presentation.person

import com.asteam.itaghvim.domain.model.CalendarEvent
import com.asteam.itaghvim.domain.model.Person

/**
 * وضعیت صفحه جزئیات شخص
 * مدیریت اطلاعات شخص و مناسبت های مرتبط
 */
data class PersonDetailUiState(
    val person: Person? = null,
    val events: List<CalendarEvent> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
