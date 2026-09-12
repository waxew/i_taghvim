package com.asteam.itaghvim.core.ads

import javax.inject.Inject

class PremiumFeatureRepositoryImpl @Inject constructor(
    private val dataStoreRepository: PremiumDataStoreRepository
) : PremiumFeatureRepository {

    override suspend fun unlockFeature(featureId: String) {
        dataStoreRepository.unlockFeature(featureId)
    }

    override suspend fun isFeatureUnlocked(featureId: String): Boolean {
        return dataStoreRepository.isUnlocked(featureId)
    }

    override suspend fun clearUnlockedFeatures() {
        dataStoreRepository.clearFeatures()
    }
}
