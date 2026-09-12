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

    @Query("DELETE FROM persons WHERE id = :id")
    suspend fun deleteById(id: Long)

    @Query("SELECT * FROM persons ORDER BY name")
    fun getAll(): Flow<List<PersonEntity>>

    @Query("SELECT * FROM persons WHERE id = :id LIMIT 1")
    fun getById(id: Long): Flow<PersonEntity?>

    @Query("SELECT * FROM persons WHERE name LIKE '%' || :query || '%'")
    fun search(query: String): Flow<List<PersonEntity>>
}
