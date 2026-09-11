package com.asteam.itaghvim.core.ads

/**
 * وضعیت قابلیت های ویژه برنامه.
 * این لایه بعداً به DataStore متصل می شود.
 */
data class PremiumFeatureState(
    val unlockedFeatures: Set<String> = emptySet()
) {
    fun isUnlocked(featureId: String): Boolean {
        return unlockedFeatures.contains(featureId)
    }

    fun unlock(featureId: String): PremiumFeatureState {
        return copy(
            unlockedFeatures = unlockedFeatures + featureId
        )
    }
}
