package com.asteam.itaghvim.domain.usecase

import com.asteam.itaghvim.domain.model.PersonProfile
import com.asteam.itaghvim.domain.repository.PersonRepository
import kotlinx.coroutines.flow.Flow

/**
 * دریافت لیست اشخاص از لایه Domain
 */
class GetPersonsUseCase(
    private val repository: PersonRepository
) {
    operator fun invoke(): Flow<List<PersonProfile>> {
        return repository.getPersons()
    }
}
