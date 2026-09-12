package com.asteam.itaghvim.domain.usecase

import com.asteam.itaghvim.domain.model.PersonWithEvents
import com.asteam.itaghvim.domain.model.PersonProfile
import com.asteam.itaghvim.domain.repository.PersonRepository
import com.asteam.itaghvim.domain.repository.EventRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class GetPersonDetailUseCase @Inject constructor(
    private val repository: PersonRepository,
    private val events: EventRepository
) {
    operator fun invoke(id: Long): Flow<PersonWithEvents?> =
        combine(repository.getPersonById(id), events.getEvents()) { person, allEvents ->
            person?.let { PersonWithEvents(PersonProfile(it.id, it.name, it.notes),
                allEvents.filter { event -> event.personName == it.name }) }
        }
}
