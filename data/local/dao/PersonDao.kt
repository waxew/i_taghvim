package com.asteam.itaghvim.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.asteam.itaghvim.data.local.entity.PersonEntity
import kotlinx.coroutines.flow.Flow

/**
 * دسترسی به اطلاعات اشخاص در دیتابیس Room
 */
@Dao
interface PersonDao {

    @Insert
    suspend fun insert(person: PersonEntity)

    @Query("SELECT * FROM persons ORDER BY name ASC")
    fun getAll(): Flow<List<PersonEntity>>

    @Query("SELECT * FROM persons WHERE name LIKE '%' || :query || '%'")
    fun searchByName(query: String): Flow<List<PersonEntity>>

    @Query("DELETE FROM persons WHERE id = :id")
    suspend fun delete(id: Long)
}
