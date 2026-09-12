package com.asteam.itaghvim.presentation.person

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asteam.itaghvim.domain.model.Person
import com.asteam.itaghvim.domain.usecase.AddPersonUseCase
import com.asteam.itaghvim.domain.usecase.DeletePersonUseCase
import com.asteam.itaghvim.domain.usecase.GetPersonsUseCase
import com.asteam.itaghvim.domain.usecase.UpdatePersonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonViewModel @Inject constructor(
    private val getPersonsUseCase: GetPersonsUseCase,
    private val addPersonUseCase: AddPersonUseCase,
    private val updatePersonUseCase: UpdatePersonUseCase,
    private val deletePersonUseCase: DeletePersonUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(PersonUiState())
    val state: StateFlow<PersonUiState> = _state

    fun loadPersons() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)

            getPersonsUseCase()
                .catch {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        errorMessage = it.message
                    )
                }
                .collectLatest { persons ->
                    _state.value = _state.value.copy(
                        isLoading = false,
                        persons = persons
                    )
                }
        }
    }

    fun addPerson(person: Person) {
        viewModelScope.launch {
            addPersonUseCase(person)
        }
    }

    fun updatePerson(person: Person) {
        viewModelScope.launch {
            updatePersonUseCase(person)
        }
    }

    fun deletePerson(id: Long) {
        viewModelScope.launch {
            deletePersonUseCase(id)
        }
    }
}
