package com.asteam.itaghvim.core.ads

/**
 * DataStore abstraction for premium feature persistence.
 *
 * Keeps storage details separated from business logic.
 */
interface PremiumDataStore {
    suspend fun saveUnlockedFeature(featureId: String)
    suspend fun isFeatureUnlocked(featureId: String): Boolean
    suspend fun clearUnlockedFeatures()
}
