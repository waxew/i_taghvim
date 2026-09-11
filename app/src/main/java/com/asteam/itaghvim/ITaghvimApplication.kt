package com.asteam.itaghvim

import android.app.Application
import com.asteam.itaghvim.core.ads.TapsellInitializer
import dagger.hilt.android.HiltAndroidApp

/**
 * کلاس اصلی برنامه
 * نقطه شروع Dependency Injection با Hilt
 */
@HiltAndroidApp
class ITaghvimApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        TapsellInitializer.initialize(this)
    }
}
