package com.asteam.itaghvim.core.ads

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

private const val PREMIUM_DATASTORE_NAME = "premium_preferences"

val Context.premiumDataStore: DataStore<Preferences> by preferencesDataStore(
    name = PREMIUM_DATASTORE_NAME
)

object DataStoreProvider {
    const val STORE_NAME = PREMIUM_DATASTORE_NAME
}
