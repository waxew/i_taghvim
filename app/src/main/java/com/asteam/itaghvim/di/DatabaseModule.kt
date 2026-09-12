package com.asteam.itaghvim.di

import android.content.Context
import androidx.room.Room
import com.asteam.itaghvim.data.local.dao.EventDao
import com.asteam.itaghvim.data.local.dao.PersonDao
import com.asteam.itaghvim.data.local.database.AppDatabase
import com.asteam.itaghvim.data.local.database.migration.DatabaseMigrations
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * ماژول تزریق وابستگی دیتابیس
 */
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "itag_hv_database"
        )
            .addMigrations(DatabaseMigrations.MIGRATION_1_2)
            .build()
    }

    @Provides
    fun provideEventDao(
        database: AppDatabase
    ): EventDao {
        return database.eventDao()
    }

    @Provides
    fun providePersonDao(
        database: AppDatabase
    ): PersonDao {
        return database.personDao()
    }
}
