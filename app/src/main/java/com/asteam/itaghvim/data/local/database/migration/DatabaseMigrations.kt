package com.asteam.itaghvim.data.local.database.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

/**
 * Room migration definitions.
 * Version 1 -> 2 adds calendar core tables.
 */
object DatabaseMigrations {

    val MIGRATION_1_2 = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL(
                """
                CREATE TABLE IF NOT EXISTS `events` (
                    `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                    `title` TEXT NOT NULL,
                    `personName` TEXT NOT NULL,
                    `dateSolar` TEXT NOT NULL,
                    `dateLunar` TEXT,
                    `dateGregorian` TEXT,
                    `note` TEXT
                )
                """.trimIndent()
            )

            database.execSQL(
                """
                CREATE TABLE IF NOT EXISTS `persons` (
                    `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                    `name` TEXT NOT NULL,
                    `birthday` TEXT,
                    `marriageDate` TEXT,
                    `notes` TEXT
                )
                """.trimIndent()
            )
        }
    }
}
