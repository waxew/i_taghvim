package com.asteam.itaghvim.core.ads

import javax.inject.Inject

class PremiumDataStoreRepositoryImpl @Inject constructor(
    private val dataStore: PremiumDataStore
) : PremiumDataStoreRepository {

    override suspend fun unlockFeature(featureId: String) {
        dataStore.saveUnlockedFeature(featureId)
    }

    override suspend fun isUnlocked(featureId: String): Boolean {
        return dataStore.isFeatureUnlocked(featureId)
    }

    override suspend fun clearFeatures() {
        dataStore.clearUnlockedFeatures()
    }
}
