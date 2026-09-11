package com.asteam.itaghvim.di

import com.asteam.itaghvim.core.ads.AdProvider
import com.asteam.itaghvim.core.ads.TapsellAdProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Dependency Injection module for advertisement services.
 */
@Module
@InstallIn(SingletonComponent::class)
object AdsModule {

    @Provides
    @Singleton
    fun provideAdProvider(): AdProvider {
        return TapsellAdProvider()
    }
}
