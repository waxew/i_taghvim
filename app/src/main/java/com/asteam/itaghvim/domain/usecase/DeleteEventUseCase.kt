package com.asteam.itaghvim.domain.usecase

import com.asteam.itaghvim.domain.model.CalendarEvent
import com.asteam.itaghvim.domain.repository.EventRepository
import javax.inject.Inject

/**
 * حذف مناسبت از برنامه
 */
class DeleteEventUseCase @Inject constructor(
    private val repository: EventRepository
) {
    suspend operator fun invoke(event: CalendarEvent) {
        repository.deleteEvent(event)
    }
}
