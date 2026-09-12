package com.asteam.itaghvim.domain.usecase

import com.asteam.itaghvim.domain.model.CalendarEvent
import com.asteam.itaghvim.domain.repository.EventRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetEventsByDateUseCase @Inject constructor(
    private val repository: EventRepository
) {
    operator fun invoke(date: String): Flow<List<CalendarEvent>> {
        return repository.getEventsByDate(date)
    }
}
