package com.asteam.itaghvim.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * موجودیت شخص برای ذخیره اطلاعات افراد در دیتابیس داخلی
 */
@Entity(tableName = "persons")
data class PersonEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val description: String? = null,
    val profileImage: String? = null
)
