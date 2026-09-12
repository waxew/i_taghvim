package com.asteam.itaghvim.domain.usecase

import com.asteam.itaghvim.domain.repository.EventRepository

/**
 * جستجوی مناسبت ها بر اساس نام شخص
 */
import javax.inject.Inject

class SearchEventsUseCase @Inject constructor(
    private val repository: EventRepository
) {
    operator fun invoke(name: String) = repository.search(name)
}
