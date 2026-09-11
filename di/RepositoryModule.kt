package com.asteam.itaghvim.di

import com.asteam.itaghvim.data.repository.PersonRepositoryImpl
import com.asteam.itaghvim.domain.repository.PersonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// ماژول اتصال Repository ها در Dependency Injection
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    // اتصال قرارداد Domain به پیاده سازی Data
    @Binds
    @Singleton
    abstract fun bindPersonRepository(
        implementation: PersonRepositoryImpl
    ): PersonRepository
}
