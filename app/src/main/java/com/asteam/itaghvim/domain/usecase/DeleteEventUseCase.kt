package com.asteam.itaghvim.domain.usecase

import com.asteam.itaghvim.domain.repository.EventRepository

/**
 * حذف مناسبت از برنامه
 */
class DeleteEventUseCase(
    private val repository: EventRepository
) {
    suspend operator fun invoke(id: Long) {
        repository.deleteEvent(id)
    }
}
