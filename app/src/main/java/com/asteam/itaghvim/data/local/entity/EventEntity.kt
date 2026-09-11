package com.asteam.itaghvim.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * جدول مناسبت های شخصی کاربر
 */
@Entity(tableName = "events")
data class EventEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val personName: String,
    val dateSolar: String,
    val dateLunar: String? = null,
    val dateGregorian: String? = null,
    val note: String? = null
)
