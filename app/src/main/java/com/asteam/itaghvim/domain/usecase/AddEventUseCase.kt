package com.asteam.itaghvim.domain.usecase

import com.asteam.itaghvim.domain.model.CalendarEvent
import com.asteam.itaghvim.domain.repository.EventRepository
import javax.inject.Inject

/**
 * ثبت مناسبت جدید در برنامه
 * منطق کسب و کار در این لایه نگهداری می شود.
 */
class AddEventUseCase @Inject constructor(
    private val repository: EventRepository
) {
    suspend operator fun invoke(event: CalendarEvent) {
        repository.addEvent(event)
    }
}
