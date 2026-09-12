package com.asteam.itaghvim.presentation.person

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asteam.itaghvim.domain.usecase.GetEventsByPersonNameUseCase
import com.asteam.itaghvim.domain.usecase.GetPersonByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonDetailViewModel @Inject constructor(
    private val getPersonByIdUseCase: GetPersonByIdUseCase,
    private val getEventsByPersonNameUseCase: GetEventsByPersonNameUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(PersonDetailUiState())
    val state: StateFlow<PersonDetailUiState> = _state.asStateFlow()

    fun loadPerson(id: Long) {
        viewModelScope.launch {
            getPersonByIdUseCase(id)
                .catch { error ->
                    _state.value = _state.value.copy(error = error.message)
                }
                .collectLatest { person ->
                    _state.value = _state.value.copy(person = person)
                    person?.let {
                        loadEvents(it.name)
                    }
                }
        }
    }

    private fun loadEvents(personName: String) {
        viewModelScope.launch {
            getEventsByPersonNameUseCase(personName)
                .catch { error ->
                    _state.value = _state.value.copy(error = error.message)
                }
                .collectLatest { events ->
                    _state.value = _state.value.copy(events = events)
                }
        }
    }
}
