package com.asteam.itaghvim.data.repository

import com.asteam.itaghvim.domain.model.PersonProfile
import com.asteam.itaghvim.domain.repository.PersonRepository

/**
 * پیاده سازی Repository اشخاص
 *
 * این کلاس واسط بین لایه Domain و منبع داده Room است.
 * اتصال نهایی به PersonDao بعد از تکمیل Database Module انجام می شود.
 */
class PersonRepositoryImpl : PersonRepository {

    override suspend fun getPersons(): List<PersonProfile> {
        return emptyList()
    }

    override suspend fun addPerson(person: PersonProfile) {
        // اتصال به DAO در مرحله اتصال Room تکمیل می شود.
    }

    override suspend fun deletePerson(id: Long) {
        // حذف شخص از دیتابیس
    }
}
