package com.asteam.itaghvim.domain.usecase

import com.asteam.itaghvim.domain.model.CalendarEvent
import com.asteam.itaghvim.domain.repository.EventRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetEventsByPersonNameUseCase @Inject constructor(
    private val repository: EventRepository
) {
    operator fun invoke(personName: String): Flow<List<CalendarEvent>> {
        return repository.getEventsByPersonName(personName)
    }
}
