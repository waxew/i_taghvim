package com.asteam.itaghvim.domain.model

/**
 * مدل ترکیبی شخص به همراه مناسبت‌های ثبت شده
 *
 * برای نمایش صفحه جزئیات شخص استفاده خواهد شد.
 */
data class PersonWithEvents(
    val person: PersonProfile,
    val events: List<CalendarEvent>
)
