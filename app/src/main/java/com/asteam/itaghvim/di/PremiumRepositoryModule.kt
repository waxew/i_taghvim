package com.asteam.itaghvim.di

import com.asteam.itaghvim.core.ads.PremiumDataStoreRepository
import com.asteam.itaghvim.core.ads.PremiumDataStoreRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class PremiumRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindPremiumDataStoreRepository(
        impl: PremiumDataStoreRepositoryImpl
    ): PremiumDataStoreRepository
}
