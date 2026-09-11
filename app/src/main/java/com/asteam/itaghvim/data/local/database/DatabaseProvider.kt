package com.asteam.itaghvim.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.asteam.itaghvim.data.local.entity.EventEntity
import com.asteam.itaghvim.data.local.entity.PersonEntity

/**
 * کلاس اصلی دیتابیس داخلی آی تقویم
 * تمام Entity های اصلی برنامه از اینجا مدیریت می شوند.
 */
@Database(
    entities = [
        PersonEntity::class,
        EventEntity::class
    ],
    version = 1,
    exportSchema = true
)
abstract class DatabaseProvider : RoomDatabase()
