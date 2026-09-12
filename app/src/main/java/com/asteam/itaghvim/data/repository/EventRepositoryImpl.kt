package com.asteam.itaghvim.data.repository

import com.asteam.itaghvim.data.local.dao.EventDao
import com.asteam.itaghvim.data.local.mapper.EventMapper
import com.asteam.itaghvim.domain.model.CalendarEvent
import com.asteam.itaghvim.domain.repository.EventRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * پیاده سازی Repository مناسبت ها
 * ارتباط بین Domain و Data در این قسمت انجام می شود.
 */
class EventRepositoryImpl @Inject constructor(
    private val eventDao: EventDao,
    private val mapper: EventMapper
) : EventRepository {

    override suspend fun addEvent(event: CalendarEvent) {
        eventDao.insert(mapper.toEntity(event))
    }

    override suspend fun updateEvent(event: CalendarEvent) {
        eventDao.update(mapper.toEntity(event))
    }

    override suspend fun deleteEvent(event: CalendarEvent) {
        eventDao.delete(mapper.toEntity(event))
    }

    override fun getEvents(): Flow<List<CalendarEvent>> {
        return eventDao.getAll().map { events ->
            events.map(mapper::toDomain)
        }
    }

    override fun getEventsByDate(date: String): Flow<List<CalendarEvent>> {
        return eventDao.getEventsByDate(date).map { events ->
            events.map(mapper::toDomain)
        }
    }

    override fun getEventsByPersonName(personName: String): Flow<List<CalendarEvent>> {
        return eventDao.getEventsByPersonName(personName).map { events ->
            events.map(mapper::toDomain)
        }
    }
}
