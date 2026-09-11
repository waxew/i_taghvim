package com.asteam.itaghvim.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.asteam.itaghvim.data.local.entity.PersonEntity

/**
 * دسترسی به اطلاعات اشخاص در دیتابیس
 */
@Dao
interface PersonDao {

    @Insert
    suspend fun insert(person: PersonEntity)

    @Query("SELECT * FROM persons ORDER BY name")
    suspend fun getAll(): List<PersonEntity>

    @Query("SELECT * FROM persons WHERE name LIKE '%' || :query || '%'")
    suspend fun search(query: String): List<PersonEntity>
}
