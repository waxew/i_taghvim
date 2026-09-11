package com.asteam.itaghvim.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * اطلاعات پروفایل کاربر
 * برای ذخیره تنظیمات شخصی و تصویر پروفایل استفاده می شود.
 */
@Entity(tableName = "user_profile")
data class UserProfileEntity(
    @PrimaryKey
    val id: Int = 1,
    val name: String = "",
    val imagePath: String = "",
    val isVip: Boolean = false,
    val vipExpireDate: Long? = null
)
