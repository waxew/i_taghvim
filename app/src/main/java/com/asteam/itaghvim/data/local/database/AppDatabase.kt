package com.asteam.itaghvim.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.asteam.itaghvim.data.local.entity.EventEntity
import com.asteam.itaghvim.data.local.entity.PersonEntity

/**
 * دیتابیس داخلی برنامه
 *
 * Phase 1:
 * اتصال Entity های اصلی تقویم و اشخاص به Room.
 */
@Database(
    entities = [
        EventEntity::class,
        PersonEntity::class
    ],
    version = 2,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase()
