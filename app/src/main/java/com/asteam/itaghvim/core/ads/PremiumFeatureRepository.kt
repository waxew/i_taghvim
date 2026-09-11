package com.asteam.itaghvim.core.ads

/**
 * Repository contract for premium feature access.
 * Keeps feature state management independent from storage implementation.
 */
interface PremiumFeatureRepository {
    suspend fun unlockFeature(featureId: String)
    suspend fun isFeatureUnlocked(featureId: String): Boolean
    suspend fun clearUnlockedFeatures()
}
