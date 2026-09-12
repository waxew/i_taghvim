package com.asteam.itaghvim.core.ads

import javax.inject.Inject

/** تمام رابط‌های Premium از یک منبع ذخیره‌سازی استفاده می‌کنند. */
class PremiumPreferencesImpl @Inject constructor(
    private val dataStore: PremiumDataStore
) : PremiumPreferences {
    override suspend fun saveUnlocked(featureId: String) = dataStore.saveUnlockedFeature(featureId)
    override suspend fun isUnlocked(featureId: String): Boolean = dataStore.isFeatureUnlocked(featureId)
    override suspend fun clearUnlocked() = dataStore.clearUnlockedFeatures()
}
