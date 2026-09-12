package com.asteam.itaghvim.domain.usecase

import com.asteam.itaghvim.domain.repository.PersonRepository

/**
 * دریافت لیست اشخاص
 * منطق برنامه در UseCase نگهداری می شود.
 */
import javax.inject.Inject

class GetPersonsUseCase @Inject constructor(
    private val repository: PersonRepository
) {
    operator fun invoke() = repository.getPersons()
}
