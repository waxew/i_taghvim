package com.asteam.itaghvim.domain.usecase

import com.asteam.itaghvim.domain.model.Person
import com.asteam.itaghvim.domain.repository.PersonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPersonByIdUseCase @Inject constructor(
    private val repository: PersonRepository
) {
    operator fun invoke(id: Long): Flow<Person?> {
        return repository.getPersonById(id)
    }
}
