package com.asteam.itaghvim.core.ads

class PremiumUnlockManager {

    private var unlockedFeatures: MutableSet<String> = mutableSetOf()

    fun unlock(featureId: String) {
        unlockedFeatures.add(featureId)
    }

    fun isUnlocked(featureId: String): Boolean {
        return unlockedFeatures.contains(featureId)
    }

    fun clear() {
        unlockedFeatures.clear()
    }
}
