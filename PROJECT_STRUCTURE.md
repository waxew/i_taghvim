# ساختار معماری iTaghvim

## معماری
Clean Architecture + MVVM

لایه ها:
- data: دیتابیس Room، DAO، Entity و Repository implementation
- domain: مدل ها و UseCase ها
- presentation: Compose UI و ViewModel ها
- core: تنظیمات پایه، ثابت ها و ابزارهای مشترک

## قوانین توسعه
- اطلاعات پایه برنامه فقط از AppConfig خوانده می شود.
- تمام کلاس ها در پکیج مستقل قرار می گیرند.
- توضیحات کد به زبان فارسی نوشته خواهد شد.
