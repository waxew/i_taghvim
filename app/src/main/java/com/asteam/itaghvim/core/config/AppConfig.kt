package com.asteam.itaghvim.core.config

/**
 * تنظیمات مرکزی برنامه آی تقویم
 * تمام اطلاعات پایه برنامه باید از این فایل خوانده شود.
 */
object AppConfig {

    const val APP_NAME = "آی تقویم"
    const val PACKAGE_NAME = "com.asteam.itaghvim"
    const val VERSION_NAME = "1.0.0"
    const val VERSION_CODE = 1

    object Company {
        const val NAME = "AS Team"
        const val SUPPORT_EMAIL = "AS.Developers.Support@Gmail.Com"
    }

    object Ads {
        // فعال یا غیرفعال کردن کلی تبلیغات
        const val ENABLED = true

        // نمایش تبلیغ برای کاربر مهمان
        const val SHOW_FOR_GUEST = true

        // حذف تبلیغات برای کاربر VIP
        const val HIDE_FOR_VIP = true
    }

    object Update {
        const val CHECK_ON_START = true
        const val CURRENT_VERSION = VERSION_NAME
    }
}
