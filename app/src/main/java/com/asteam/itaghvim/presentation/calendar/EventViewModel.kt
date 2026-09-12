package com.asteam.itaghvim.presentation.calendar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asteam.itaghvim.domain.model.CalendarEvent
import com.asteam.itaghvim.domain.usecase.AddEventUseCase
import com.asteam.itaghvim.domain.usecase.DeleteEventUseCase
import com.asteam.itaghvim.domain.usecase.GetEventsByDateUseCase
import com.asteam.itaghvim.domain.usecase.UpdateEventUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * مدیریت منطق مناسبت ها
 * ارتباط UI با UseCase از طریق ViewModel
 */
@HiltViewModel
class EventViewModel @Inject constructor(
    private val addEventUseCase: AddEventUseCase,
    private val updateEventUseCase: UpdateEventUseCase,
    private val deleteEventUseCase: DeleteEventUseCase,
    private val getEventsByDateUseCase: GetEventsByDateUseCase
) : ViewModel() {

    fun saveEvent(event: CalendarEvent) {
        viewModelScope.launch {
            addEventUseCase(event)
        }
    }

    fun updateEvent(event: CalendarEvent) {
        viewModelScope.launch {
            updateEventUseCase(event)
        }
    }

    fun deleteEvent(event: CalendarEvent) {
        viewModelScope.launch {
            deleteEventUseCase(event)
        }
    }

    fun getEventsByDate(date: String): Flow<List<CalendarEvent>> {
        return getEventsByDateUseCase(date)
    }
}
