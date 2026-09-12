package com.asteam.itaghvim.data.local.mapper

import com.asteam.itaghvim.data.local.entity.EventEntity
import com.asteam.itaghvim.domain.model.CalendarEvent
import javax.inject.Inject

class EventMapper @Inject constructor() {

    fun toEntity(event: CalendarEvent): EventEntity {
        return EventEntity(
            id = event.id,
            title = event.title,
            personName = event.personName ?: "",
            dateSolar = event.solarDate,
            dateLunar = event.lunarDate,
            dateGregorian = event.gregorianDate,
            note = event.description
        )
    }

    fun toDomain(entity: EventEntity): CalendarEvent {
        return CalendarEvent(
            id = entity.id,
            title = entity.title,
            personName = entity.personName,
            solarDate = entity.dateSolar,
            lunarDate = entity.dateLunar,
            gregorianDate = entity.dateGregorian,
            description = entity.note
        )
    }
}
