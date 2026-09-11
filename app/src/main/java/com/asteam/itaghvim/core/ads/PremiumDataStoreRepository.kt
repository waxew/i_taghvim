package com.asteam.itaghvim.core.ads

interface PremiumDataStoreRepository {
    suspend fun unlockFeature(featureId: String)
    suspend fun isUnlocked(featureId: String): Boolean
    suspend fun clearFeatures()
}
