package com.asteam.itaghvim.domain.usecase

import com.asteam.itaghvim.domain.model.CalendarEvent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetPersonEventsUseCase @Inject constructor(
    private val details: GetPersonDetailUseCase
) {
    operator fun invoke(personId: Long): Flow<List<CalendarEvent>> =
        details(personId).map { it?.events ?: emptyList() }
}
