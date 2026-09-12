package com.asteam.itaghvim.domain.usecase

import com.asteam.itaghvim.domain.model.Person
import com.asteam.itaghvim.domain.model.PersonProfile
import com.asteam.itaghvim.domain.repository.PersonRepository

/**
 * ثبت شخص جدید
 */
import javax.inject.Inject

class AddPersonUseCase @Inject constructor(
    private val repository: PersonRepository
) {
    suspend operator fun invoke(person: Person) = repository.insertPerson(person)

    suspend operator fun invoke(person: PersonProfile) {
        repository.insertPerson(Person(id = person.id, name = person.name, notes = person.description))
    }
}
