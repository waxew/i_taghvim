package com.asteam.itaghvim.data.repository

import com.asteam.itaghvim.data.local.dao.PersonDao
import com.asteam.itaghvim.data.local.mapper.toDomain
import com.asteam.itaghvim.data.local.mapper.toEntity
import com.asteam.itaghvim.domain.model.Person
import com.asteam.itaghvim.domain.repository.PersonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * ارتباط بین Domain و Data
 * پیاده سازی CRUD اشخاص با Room
 */
class PersonRepositoryImpl @Inject constructor(
    private val personDao: PersonDao
) : PersonRepository {

    override fun getPersons(): Flow<List<Person>> {
        return personDao.getAll().map { persons ->
            persons.map { it.toDomain() }
        }
    }

    override suspend fun insertPerson(person: Person) {
        personDao.insert(person.toEntity())
    }

    override suspend fun updatePerson(person: Person) {
        personDao.update(person.toEntity())
    }

    override suspend fun deletePerson(id: Long) {
        personDao.deleteById(id)
    }

    override fun searchPerson(query: String): Flow<List<Person>> {
        return personDao.search(query).map { persons ->
            persons.map { it.toDomain() }
        }
    }
}
