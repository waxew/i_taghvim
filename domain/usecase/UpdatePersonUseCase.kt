package com.asteam.itaghvim.domain.usecase

import com.asteam.itaghvim.domain.model.PersonProfile
import com.asteam.itaghvim.domain.repository.PersonRepository

// این UseCase برای ویرایش اطلاعات شخص استفاده می‌شود.
import javax.inject.Inject
import com.asteam.itaghvim.domain.model.Person

class UpdatePersonUseCase @Inject constructor(
    private val repository: PersonRepository
) {
    suspend operator fun invoke(person: Person) = repository.updatePerson(person)

    suspend operator fun invoke(person: PersonProfile) {
        repository.updatePerson(Person(id = person.id, name = person.name, notes = person.description))
    }
}
