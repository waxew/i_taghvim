package com.asteam.itaghvim.domain.usecase

import com.asteam.itaghvim.domain.model.CalendarEvent
import com.asteam.itaghvim.domain.repository.EventRepository
import kotlinx.coroutines.flow.Flow

/**
 * دریافت لیست مناسبت ها از لایه Domain
 */
class GetEventsUseCase(
    private val repository: EventRepository
) {
    operator fun invoke(): Flow<List<CalendarEvent>> {
        return repository.getEvents()
    }
}
