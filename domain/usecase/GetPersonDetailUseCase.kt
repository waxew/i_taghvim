package com.asteam.itaghvim.domain.usecase

import com.asteam.itaghvim.domain.model.PersonWithEvents
import com.asteam.itaghvim.domain.repository.PersonRepository
import kotlinx.coroutines.flow.Flow

// این UseCase مسئول دریافت جزئیات یک شخص و مناسبت‌های مرتبط با او است.
class GetPersonDetailUseCase(
    private val repository: PersonRepository
) {
    operator fun invoke(id: Long): Flow<PersonWithEvents?> {
        return repository.getPersonDetail(id)
    }
}
