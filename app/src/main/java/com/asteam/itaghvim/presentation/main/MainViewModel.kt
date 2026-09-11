package com.asteam.itaghvim.presentation.main

import androidx.lifecycle.ViewModel
import com.asteam.itaghvim.core.config.AppConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * ViewModel اصلی برنامه
 * مدیریت وضعیت های عمومی مانند نسخه و تنظیمات پایه.
 */
@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    val appName = AppConfig.APP_NAME
    val version = AppConfig.VERSION_NAME
}
