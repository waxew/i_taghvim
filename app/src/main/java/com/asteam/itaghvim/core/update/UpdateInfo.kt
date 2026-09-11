package com.asteam.itaghvim.core.update

/**
 * اطلاعات نسخه جدید برنامه
 */
data class UpdateInfo(
    val versionName: String,
    val versionCode: Int,
    val downloadUrl: String,
    val description: String
)
