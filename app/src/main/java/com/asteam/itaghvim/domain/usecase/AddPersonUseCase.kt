package com.asteam.itaghvim.domain.usecase

import com.asteam.itaghvim.domain.model.PersonProfile
import com.asteam.itaghvim.domain.repository.PersonRepository

/**
 * ثبت شخص جدید
 */
class AddPersonUseCase(
    private val repository: PersonRepository
) {
    suspend operator fun invoke(person: PersonProfile) {
        repository.insert(person)
    }
}
