package com.asteam.itaghvim.core.ads

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringSetPreferencesKey
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import javax.inject.Inject

/** ذخیره پایدار امکانات بازشده با DataStore برنامه. */
class PremiumDataStoreImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : PremiumDataStore {
    private val featuresKey = stringSetPreferencesKey("unlocked_features")

    override suspend fun saveUnlockedFeature(featureId: String) {
        context.premiumDataStore.edit { preferences ->
            preferences[featuresKey] = (preferences[featuresKey] ?: emptySet()) + featureId
        }
    }

    override suspend fun isFeatureUnlocked(featureId: String): Boolean =
        featureId in (context.premiumDataStore.data.first()[featuresKey] ?: emptySet())

    override suspend fun clearUnlockedFeatures() {
        context.premiumDataStore.edit { it.remove(featuresKey) }
    }
}
