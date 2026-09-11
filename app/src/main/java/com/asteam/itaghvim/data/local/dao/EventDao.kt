package com.asteam.itaghvim.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.asteam.itaghvim.data.local.entity.EventEntity
import kotlinx.coroutines.flow.Flow

/**
 * دسترسی به اطلاعات مناسبت ها
 */
@Dao
interface EventDao {

    @Insert
    suspend fun insert(event: EventEntity)

    @Query("SELECT * FROM events ORDER BY dateSolar")
    fun getAll(): Flow<List<EventEntity>>

    @Query("SELECT * FROM events WHERE personName LIKE '%' || :name || '%'")
    fun search(name: String): Flow<List<EventEntity>>
}
