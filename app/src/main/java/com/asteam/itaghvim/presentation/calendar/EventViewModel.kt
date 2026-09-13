package com.asteam.itaghvim.presentation.calendar
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asteam.itaghvim.domain.model.CalendarEvent
import com.asteam.itaghvim.domain.usecase.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

/** مدیریت منطق ذخیره، ویرایش و حذف مناسبت‌ها. */
@HiltViewModel
class EventViewModel @Inject constructor(
 private val addEventUseCase:AddEventUseCase,
 private val updateEventUseCase:UpdateEventUseCase,
 private val deleteEventUseCase:DeleteEventUseCase,
 private val getEventsByDateUseCase:GetEventsByDateUseCase
):ViewModel(){
 fun saveEvent(event:CalendarEvent,onSaved:()->Unit={}){viewModelScope.launch{runCatching{addEventUseCase(event)}.onSuccess{onSaved()}}}
 fun updateEvent(event:CalendarEvent){viewModelScope.launch{updateEventUseCase(event)}}
 fun deleteEvent(event:CalendarEvent){viewModelScope.launch{deleteEventUseCase(event)}}
 fun getEventsByDate(date:String):Flow<List<CalendarEvent>>=getEventsByDateUseCase(date)
}