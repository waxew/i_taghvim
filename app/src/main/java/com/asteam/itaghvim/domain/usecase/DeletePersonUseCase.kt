package com.asteam.itaghvim.domain.usecase

import com.asteam.itaghvim.domain.repository.PersonRepository

/**
 * حذف شخص از اطلاعات برنامه
 */
import javax.inject.Inject

class DeletePersonUseCase @Inject constructor(
    private val repository: PersonRepository
) {
    suspend operator fun invoke(id: Long) {
        repository.deletePerson(id)
    }
}
