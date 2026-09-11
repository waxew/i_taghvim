package com.asteam.itaghvim.di

import com.asteam.itaghvim.core.ads.PremiumDataStore
import com.asteam.itaghvim.core.ads.PremiumDataStoreImpl
import com.asteam.itaghvim.core.ads.PremiumPreferences
import com.asteam.itaghvim.core.ads.PremiumPreferencesImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PremiumModule {

    @Provides
    @Singleton
    fun providePremiumPreferences(
        impl: PremiumPreferencesImpl
    ): PremiumPreferences = impl

    @Provides
    @Singleton
    fun providePremiumDataStore(
        impl: PremiumDataStoreImpl
    ): PremiumDataStore = impl
}
