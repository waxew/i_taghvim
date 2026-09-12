package com.asteam.itaghvim.di

import com.asteam.itaghvim.data.repository.PersonRepositoryImpl
import com.asteam.itaghvim.domain.repository.PersonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * اتصال Interface های Domain به پیاده سازی Data
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {
    @Binds
    abstract fun bindEventRepository(
        implementation: com.asteam.itaghvim.data.repository.EventRepositoryImpl
    ): com.asteam.itaghvim.domain.repository.EventRepository


    @Binds
    abstract fun bindPersonRepository(
        repositoryImpl: PersonRepositoryImpl
    ): PersonRepository
}
