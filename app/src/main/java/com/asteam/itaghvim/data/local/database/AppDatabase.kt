package com.asteam.itaghvim.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * دیتابیس داخلی برنامه
 * Entity ها در مراحل بعدی اضافه می شوند.
 */
@Database(
    entities = [],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase()
