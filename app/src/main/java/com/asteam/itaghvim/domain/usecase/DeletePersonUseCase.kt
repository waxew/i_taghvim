package com.asteam.itaghvim.domain.usecase

import com.asteam.itaghvim.domain.repository.PersonRepository

/**
 * حذف شخص از اطلاعات برنامه
 */
class DeletePersonUseCase(
    private val repository: PersonRepository
) {
    suspend operator fun invoke(id: Long) {
        repository.delete(id)
    }
}
