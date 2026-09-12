package com.asteam.itaghvim.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.asteam.itaghvim.data.local.entity.PersonEntity
import kotlinx.coroutines.flow.Flow

/**
 * دسترسی به اطلاعات اشخاص در دیتابیس
 */
@Dao
interface PersonDao {

    @Insert
    suspend fun insert(person: PersonEntity)

    @Update
    suspend fun update(person: PersonEntity)

    @Delete
    suspend fun delete(person: PersonEntity)

    @Query("SELECT * FROM persons ORDER BY name")
    fun getAll(): Flow<List<PersonEntity>>

    @Query("SELECT * FROM persons WHERE name LIKE '%' || :query || '%'")
    fun search(query: String): Flow<List<PersonEntity>>
}
