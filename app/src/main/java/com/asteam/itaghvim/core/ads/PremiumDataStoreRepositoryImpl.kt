package com.asteam.itaghvim.core.ads

import kotlinx.coroutines.flow.Flow

class PremiumDataStoreRepositoryImpl(
    private val dataStore: PremiumDataStore
) : PremiumDataStoreRepository {

    override suspend fun unlockFeature(featureId: String) {
        dataStore.saveUnlockedFeature(featureId)
    }

    override fun isUnlocked(featureId: String): Flow<Boolean> {
        return dataStore.isFeatureUnlocked(featureId)
    }

    override suspend fun clearFeatures() {
        dataStore.clearUnlockedFeatures()
    }
}
