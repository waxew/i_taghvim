package com.asteam.itaghvim.data.repository

import com.asteam.itaghvim.data.local.dao.EventDao
import com.asteam.itaghvim.data.local.entity.EventEntity
import com.asteam.itaghvim.domain.repository.EventRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * پیاده سازی Repository مناسبت ها
 * ارتباط بین Domain و Room در این قسمت انجام می شود.
 */
class EventRepositoryImpl @Inject constructor(
    private val eventDao: EventDao
) : EventRepository {

    override suspend fun addEvent(event: EventEntity) {
        eventDao.insert(event)
    }

    override fun getEvents(): Flow<List<EventEntity>> {
        return eventDao.getAll()
    }

    override fun search(name: String): Flow<List<EventEntity>> {
        return eventDao.search(name)
    }
}
