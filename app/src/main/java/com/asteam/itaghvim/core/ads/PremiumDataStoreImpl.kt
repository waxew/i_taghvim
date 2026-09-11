package com.asteam.itaghvim.core.ads

/**
 * Concrete implementation layer for premium persistence.
 * The storage engine will be connected through DataStore Preferences.
 */
class PremiumDataStoreImpl : PremiumDataStore {

    private val unlockedFeatures = mutableSetOf<String>()

    override suspend fun saveUnlockedFeature(featureId: String) {
        unlockedFeatures.add(featureId)
    }

    override suspend fun isFeatureUnlocked(featureId: String): Boolean {
        return unlockedFeatures.contains(featureId)
    }

    override suspend fun clearUnlockedFeatures() {
        unlockedFeatures.clear()
    }
}
