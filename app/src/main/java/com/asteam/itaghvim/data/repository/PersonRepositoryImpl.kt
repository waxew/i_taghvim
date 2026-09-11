package com.asteam.itaghvim.data.repository

import com.asteam.itaghvim.domain.repository.PersonRepository

/**
 * پیاده سازی Repository
 * ارتباط بین Domain و Data در این لایه انجام می شود.
 */
class PersonRepositoryImpl : PersonRepository {

    override fun getPersons() = TODO("در مرحله اتصال Room تکمیل می شود")

    override suspend fun insertPerson(person: com.asteam.itaghvim.domain.model.Person) {
        // TODO اتصال به DAO
    }

    override suspend fun deletePerson(id: Long) {
        // TODO اتصال به DAO
    }

    override suspend fun searchPerson(query: String) = TODO("جستجو از DAO")
}
