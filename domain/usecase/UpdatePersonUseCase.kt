package com.asteam.itaghvim.domain.usecase

import com.asteam.itaghvim.domain.model.PersonProfile
import com.asteam.itaghvim.domain.repository.PersonRepository

// این UseCase برای ویرایش اطلاعات شخص استفاده می‌شود.
class UpdatePersonUseCase(
    private val repository: PersonRepository
) {
    suspend operator fun invoke(person: PersonProfile) {
        repository.updatePerson(person)
    }
}
