package com.asteam.itaghvim.core.ads

/**
 * Implementation layer for premium feature persistence.
 * DataStore integration will be connected in the next step.
 */
class PremiumPreferencesImpl : PremiumPreferences {

    private val unlockedFeatures = mutableSetOf<String>()

    override fun saveUnlocked(featureId: String) {
        unlockedFeatures.add(featureId)
    }

    override fun isUnlocked(featureId: String): Boolean {
        return unlockedFeatures.contains(featureId)
    }

    override fun clearUnlocked() {
        unlockedFeatures.clear()
    }
}
