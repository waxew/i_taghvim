package com.asteam.itaghvim.domain.repository

import com.asteam.itaghvim.domain.model.Person
import kotlinx.coroutines.flow.Flow

/**
 * قرارداد دسترسی به اطلاعات اشخاص
 * لایه Domain نباید وابسته به دیتابیس باشد.
 */
interface PersonRepository {
    fun getPersons(): Flow<List<Person>>
    fun getPersonById(id: Long): Flow<Person?>
    suspend fun insertPerson(person: Person)
    suspend fun updatePerson(person: Person)
    suspend fun deletePerson(id: Long)
    fun searchPerson(query: String): Flow<List<Person>>
}
