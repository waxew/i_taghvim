package com.asteam.itaghvim.domain.repository

import com.asteam.itaghvim.domain.model.CalendarEvent
import kotlinx.coroutines.flow.Flow

/**
 * قرارداد ارتباط مناسبت ها بین Domain و Data
 */
interface EventRepository {

    suspend fun addEvent(event: CalendarEvent)

    fun getEvents(): Flow<List<CalendarEvent>>
}
