package com.asteam.itaghvim.domain.usecase.compat

import com.asteam.itaghvim.domain.model.PersonProfile
import com.asteam.itaghvim.domain.repository.PersonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * دریافت لیست اشخاص از لایه Domain
 */
class GetPersonsUseCase(
    private val repository: PersonRepository
) {
    operator fun invoke(): Flow<List<PersonProfile>> {
        return repository.getPersons().map { people -> people.map { PersonProfile(it.id, it.name, it.notes) } }
    }
}
