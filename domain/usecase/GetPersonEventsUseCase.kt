package com.asteam.itaghvim.domain.usecase

import com.asteam.itaghvim.domain.model.CalendarEvent
import com.asteam.itaghvim.domain.repository.PersonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * دریافت مناسبت‌های مرتبط با یک شخص
 */
class GetPersonEventsUseCase @Inject constructor(
    private val personRepository: PersonRepository
) {
    operator fun invoke(personId: Long): Flow<List<CalendarEvent>> {
        return personRepository.getPersonEvents(personId)
    }
}
