package com.asteam.itaghvim.di

import com.asteam.itaghvim.core.ads.PremiumFeatureRepository
import com.asteam.itaghvim.core.ads.PremiumFeatureRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class PremiumFeatureModule {

    @Binds
    @Singleton
    abstract fun bindPremiumFeatureRepository(
        implementation: PremiumFeatureRepositoryImpl
    ): PremiumFeatureRepository
}
