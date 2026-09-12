package com.asteam.itaghvim.data.repository

import com.asteam.itaghvim.data.local.dao.PersonDao
import com.asteam.itaghvim.data.local.entity.PersonEntity
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

    override suspend fun deletePerson(id: Long) {
        personDao.delete(
            PersonEntity(
                id = id,
                name = "",
                birthday = null,
                marriageDate = null,
                notes = null
            )
        )
    }

    override fun searchPerson(query: String): Flow<List<Person>> {
        return personDao.search(query).map { persons ->
            persons.map { it.toDomain() }
        }
    }

    private fun PersonEntity.toDomain(): Person {
        return Person(
            id = id,
            name = name,
            birthday = birthday,
            marriageDate = marriageDate,
            notes = notes
        )
    }

    private fun Person.toEntity(): PersonEntity {
        return PersonEntity(
            id = id,
            name = name,
            birthday = birthday,
            marriageDate = marriageDate,
            notes = notes
        )
    }
}
