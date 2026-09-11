package com.asteam.itaghvim.core.ads

/**
 * Contract for persisting premium unlock state.
 * Implementation can use DataStore or another persistence layer.
 */
interface PremiumPreferences {
    suspend fun saveUnlocked(featureId: String)
    suspend fun isUnlocked(featureId: String): Boolean
    suspend fun clearUnlocked()
}
